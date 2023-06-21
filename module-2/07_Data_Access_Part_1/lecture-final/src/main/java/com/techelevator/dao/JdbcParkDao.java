package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {

        //Step 1 - declare the variable we want to return
        int parkCount = 0;

        //Step 2 - write the sql and store it as a string
        String sql = "SELECT COUNT(*) AS park_count " +
                        "FROM park;";

        //Step 3 - send the sql to the database and store the results
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        //Step 4 - convert the results to java objects
        if(results.next()){
            parkCount = results.getInt("park_count");
        }

        //Step 5 - return the value
        return parkCount;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        return null;
    }
    
    @Override
    public double getAvgParkArea() {
        return 0.0;
    }
    
    @Override
    public List<String> getParkNames() {
        return new ArrayList<>();
    }
    
    @Override
    public Park getRandomPark() {
        return new Park();
    }

    @Override
    public List<Park> getParksWithCamping() {
        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {

        //Step 1 - declare what we want to return
        Park parkResult = null;

        //Step 2 - write the sql and save it as a string
        String sql = "SELECT park_id, park_name, date_established, area, has_camping\n" +
                "FROM park\n" +
                "WHERE park_id = ?;";

        //Step 3 - send the sql to the database and store the results
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        //Step 4 - convert database results to java objects
        while(results.next()){

           parkResult = mapRowToPark(results);
        }

        //Step 5 = return value
        return parkResult;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<>();
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) { return new ArrayList<>(); }

    private Park mapRowToPark(SqlRowSet results) {

        Park parkResult = new Park();

        int parkResultId = results.getInt("park_id");
        parkResult.setParkId(parkResultId);

        String parkName = results.getString("park_name");
        parkResult.setParkName(parkName);

        //to avoid the null pointer exception
        if(results.getDate("date_established") != null) {
            LocalDate date = results.getDate("date_established").toLocalDate();
            parkResult.setDateEstablished(date);
        }

        double area = results.getDouble("area");
        parkResult.setArea(area);

        boolean hasCamping = results.getBoolean("has_camping");
        parkResult.setHasCamping(hasCamping);

        return parkResult;
    }
}
