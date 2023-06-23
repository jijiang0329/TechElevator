package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT +
				" WHERE d.department_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				department = mapRowToDepartment(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to get");
		} catch (Exception ex){
			throw new DaoException("Error getting record", ex);
		}

		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to get");
		} catch (Exception ex){
			throw new DaoException("Error getting record", ex);
		}
		
		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		Department newDepartment = null;
		String sql = "INSERT INTO department(name)\n" +
				"VALUES(?) RETURNING department_id;";

		try {
			int newDepartmentID = jdbcTemplate.queryForObject(sql, int.class, department.getName());
			newDepartment = getDepartmentById(newDepartmentID);
		} catch(Exception ex){
			throw new DaoException("Unable to create new department", ex);
		}

		return newDepartment;
	}

	@Override
	public Department updateDepartment(Department department) {
		String sql = "UPDATE department\n" +
				"SET name = ?" +
				"WHERE department_id = ?;";

		try {
			jdbcTemplate.update(sql, department.getName(), department.getId());
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Not able to update");
		} catch(Exception ex){
			throw new DaoException("Error updating record", ex);
		}

		return getDepartmentById(department.getId());
	}

	@Override
	public int deleteDepartmentById(int id) {
		int numRowsDeleted = 0;
		String sql = "UPDATE employee SET department_id = 0 WHERE department_id = ?";
		String sql2 = "DELETE FROM department WHERE department_id = ?";
		 try {
			 jdbcTemplate.update(sql, id);
			 numRowsDeleted = jdbcTemplate.update(sql2, id);
		 } catch(Exception ex) {
			 throw new DaoException("Error deleting record");
		 }
		 return numRowsDeleted;
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
