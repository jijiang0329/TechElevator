package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Employee;

public class JdbcEmployeeDao implements EmployeeDao {

	private final String EMPLOYEE_SELECT = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, " +
				"e.birth_date, e.hire_date FROM employee e ";

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		String sql = EMPLOYEE_SELECT +
				" WHERE e.employee_id=?";

		 try {
			 SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			 if (results.next()) {
			 employee = mapRowToEmployee(results);
			 }
		 } catch (CannotGetJdbcConnectionException e) {
			 throw new DaoException("Not able to get");
		 } catch (Exception ex){
			 throw new DaoException("Error getting record", ex);
		 }

		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to get");
		} catch(Exception ex){
			throw new DaoException("Error getting record", ex);
		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByFirstNameLastName(String firstName, String lastName) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT +
				" WHERE e.first_name ILIKE ? AND e.last_name ILIKE ?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstName + "%", "%" + lastName + "%");
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to get");
		} catch(Exception ex){
			throw new DaoException("Error getting record", ex);
		}
		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql =  EMPLOYEE_SELECT +
				"JOIN project_employee pe ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = ?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to get");
		} catch (Exception ex){
			throw new DaoException("Error getting record", ex);
		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT +
				" WHERE e.employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to get");
		} catch (Exception ex){
			throw new DaoException("Error getting record", ex);
		}

		return allEmployees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		//Step 1 - declare what we are going to return
		Employee newEmployee = null;

		//Step 2 - write our sql and save it as a string
		String sql = "INSERT INTO employee(department_id, first_name, last_name, birth_date, hire_date)\n" +
				"VALUES(?,?,?,?,?) RETURNING employee_id;";

		//Step 3 - send our sql to the database
		try{

			//Call queryForObject when you expect a single value to be returned
			int newEmployeeId = jdbcTemplate.queryForObject(sql, int.class, employee.getDepartmentId(),
					employee.getFirstName(), employee.getLastName(), employee.getBirthDate(), employee.getHireDate());

			//Step 4 - convert our database result to java objects (already done)

			newEmployee = getEmployeeById(newEmployeeId);

		} catch(Exception ex){
			throw new DaoException("Unable to create new employee", ex);
		}

		//Step 5 - return value
		return newEmployee;
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		//Step 1 - declare what we want to return


		//Step 2 - write the sql and save it to a string
		String sql = "UPDATE employee\n" +
				"SET employee_id = ?,\n" +
				"department_id = ?,\n" +
				"first_name = ?,\n" +
				"last_name=?,\n" +
				"birth_date=?,\n" +
				"hire_date=?\n" +
				"WHERE employee_id = ?;";

		//Step 3 - send the sql to the database
		try {
			jdbcTemplate.update(sql,employee.getId(), employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(),
					employee.getBirthDate(), employee.getHireDate(), employee.getId());

			//Step 4 - convert database results to java objects (we can skip)

		}catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to update");
		} catch(Exception ex){
			throw new DaoException("Error updating record", ex);
		}

		//Step 5 - return value
		return getEmployeeById(employee.getId());
	}

	@Override
	public int deleteEmployeeById(int id) {
		//Step 1 declare what we want to return (unnecessary)
		int numRowsDeleted = 0;

		//Step 2 write the sql
		String sql = "DELETE\n" +
				"FROM project_employee\n" +
				"WHERE employee_id = ?;";

		String sql2 = "DELETE\n" +
				"FROM employee\n" +
				"WHERE employee_id = ?;";

		//Step 3 - send the sql to the database
		try{
			//first delete any foreign key dependencies
			jdbcTemplate.update(sql, id);

			//and then delete the record
			numRowsDeleted = jdbcTemplate.update(sql2, id);

		}catch(Exception ex){
			throw new DaoException("Error deleting record");
		}

		//Step 5 - return value
		return numRowsDeleted;
	}

	@Override
	public int deleteEmployeesByDepartmentId(int departmentId) {
		//Step 1 declare what we want to return (unnecessary)
		int numRowsDeleted = 0;

		//Step 2 write the sql
		String sql1 = "DELETE\n" +
				"FROM project_employee\n" +
				"WHERE employee_id IN (select employee_id from employee where department_id = ?);";

		String sql2 = "DELETE\n" +
				"FROM employee\n" +
				"WHERE department_id = ?;";

		//Step 3 - send the sql to the database
		try{
			//first delete any foreign key dependencies
			jdbcTemplate.update(sql1, departmentId);

			//and then delete the record
			numRowsDeleted = jdbcTemplate.update(sql2, departmentId);

		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to delete");
		} catch(Exception ex){
			throw new DaoException("Error deleting record", ex);
		}

		//Step 5 - return value
		return numRowsDeleted;
	}

	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getInt("employee_id"));
		employee.setDepartmentId(result.getInt("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDate(result.getDate("birth_date").toLocalDate());
		employee.setHireDate(result.getDate("hire_date").toLocalDate());
		return employee;
	}
}
