package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCityCount() {

        //Step 1 - declare the value that we want to return
        int count = 0;

        //Step 2 - Write our sql and store it as a string
        String sql = "SELECT COUNT(*) AS count FROM city;";

        //Step 3 - Send the sql to the database using the jdbcTemplate
        // queryForRowSet returns potential multiple rows and columns
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        //Step 4 - convert the results from the databse to our java objects
		if (results.next()) {
			count = results.getInt("count");
		}

        //Step 5 - return the value(s) we want
        return count;
    }

    @Override
    public int getMostPopulatedCity() {
        int population = 0;
        String sql = "SELECT MAX(population) AS population FROM city;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			population = results.getInt("population");
		} 
        return population;
    }

    @Override
    public int getLeastPopulatedCity() {
        int population = 0;
        String sql = "SELECT MIN(population) AS population FROM city;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			population = results.getInt("population");
		} 
        return population;
    }

    @Override
    public double getAvgCityArea() {
        double avgArea = 0.0;
        String sql = "SELECT AVG(area) AS avg_area FROM city;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			avgArea = results.getDouble("avg_area");
		} 
        return avgArea;
    }

    @Override
    public List<String> getCityNames() {
        //Step 1 - declare what we want to return
        List<String> cityNames = new ArrayList<>();

        //Step 2 - write the sql and store it as a string
        String sql = "SELECT city_name FROM city ORDER by city_name ASC;";

        //Step 3 - send that sql to the database and store the results
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        //Step 4 - convert the results from the db to our java objects
        while (results.next()) {
            cityNames.add(results.getString("city_name"));
        }

        //Step 5 - return the value
        return cityNames;
    }

    @Override
    public City getRandomCity() {

        //Step 1 - declare what we want to return
        City city = null;

        //Step 2 - write our sql and store it as a string
        String sql = "SELECT * FROM city ORDER BY RANDOM() LIMIT 1;";

        //step 3 - send teh sql to the database and store results
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        //Step 4 - convert results to java objects
        if (rowSet.next()) {

            int cityId = rowSet.getInt("city_id");
            city.setCityId(cityId);

            city.setCityName(rowSet.getString("city_name"));
            city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
            city.setPopulation(rowSet.getInt("population"));
            city.setArea(rowSet.getDouble("area"));
        }

        //Step 5 - return value
        return city;
    }

    @Override
    public City getCityById(int cityId) {
        City city = null;
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE city_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);
        if (results.next()) {
            city = mapRowToCity(results);
        }
        return city;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            cities.add(mapRowToCity(results));
        }
        return cities;
    }

    public List<City> getCitiesByStateOnlyName(String stateAbbreviation) {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT city_id, city_name " +
                "FROM city " +
                "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            City city = new City();

            int cityId = results.getInt("city_id");
            city.setCityId(cityId);

            city.setCityName(results.getString("city_name"));

            cities.add(city);
        }
        return cities;
    }

    private City mapRowToCity(SqlRowSet rowSet) {
        City city = new City();

        int cityId = rowSet.getInt("city_id");
        city.setCityId(cityId);

        city.setCityName(rowSet.getString("city_name"));
        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));
        return city;
    }
}
