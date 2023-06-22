package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount = 0;
        String sql = "SELECT COUNT(*) AS count FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			parkCount = results.getInt("count");
		} 
        return parkCount;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name FROM park ORDER by park_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parkNames.add(results.getString("park_name"));
        }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE has_camping = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                     "FROM park p " +
                     "JOIN park_state ps ON p.park_id = ps.park_id " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        //Step 1 - declare what we are going to return
        Park newPark = null;

        //Step 2 - write our sql and save it as a string
        String sql = "INSERT INTO park(park_name, date_established, area, has_camping)\n" +
                "VALUES(?,?,?,?) RETURNING park_id;";

        //Step 3 - send our sql to the database
        try{

            //Call queryForObject when you expect a single value to be returned
            int newParkId = jdbcTemplate.queryForObject(sql, int.class, park.getParkName(),
                    park.getDateEstablished(), park.getArea(), park.getHasCamping());

            //Step 4 - convert our database result to java objects (already done)

            newPark = getParkById(newParkId);

        } catch(Exception ex){
            throw new DaoException("Unable to create park", ex);
        }

        //Step 5 - return value
        return newPark;
    }

    public Park createPark(Park park, String stateAbbreviation) {

        Park newPark = createPark(park);
        linkParkState(newPark.getParkId(), stateAbbreviation);
        return newPark;
    }

    @Override
    public Park updatePark(Park park) {

        //Step 1 - declare what we want to return


        //Step 2 - write the sql and save it to a string
        String sql = "UPDATE park\n" +
                "SET park_name = ?,\n" +
                "date_established=?,\n" +
                "area=?,\n" +
                "has_camping=?\n" +
                "WHERE park_id = ?;";

        //Step 3 - send the sql to the database
        try {
            jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                    park.getHasCamping(), park.getParkId());

            //Step 4 - convert database results to java objects (we can skip)

        }catch(Exception ex){
            throw new DaoException("Erorr updating park", ex);
        }

        //Step 5 - return value
        return getParkById(park.getParkId());
    }

    @Override
    public int deleteParkById(int parkId) {
       //Step 1 declare what we want to return (unnecessary)
        int numRowsDeleted = 0;

        //Step 2 write the sql
        String sql = "DELETE\n" +
                "FROM park_state\n" +
                "WHERE park_id = ?;";

        String sql2 = "DELETE\n" +
                "FROM park\n" +
                "WHERE park_id = ?;";

        //Step 3 - send the sql to the database
        try{
            //first delete any foreign key dependencies
            jdbcTemplate.update(sql, parkId);

            //and then delete the record
            numRowsDeleted = jdbcTemplate.update(sql2, parkId);

        }catch(Exception ex){
            throw new DaoException("Error deleting record", ex);
        }

        //Step 5 - return value
        return numRowsDeleted;
    }

    @Override
    public void linkParkState(int parkId, String stateAbbreviation) {

        String sql = "INSERT INTO park_state(park_id, state_abbreviation) VALUES(?,?)";

        try{
            jdbcTemplate.update(sql, parkId, stateAbbreviation);
        } catch(Exception ex){
            throw new DaoException ("Error linking park", ex);
        }

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
