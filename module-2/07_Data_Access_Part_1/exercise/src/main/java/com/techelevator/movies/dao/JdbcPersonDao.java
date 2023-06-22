package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM person;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            people.add(mapRowToPerson(results));
        }
        return people;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        String sql = "select * from person where person_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next())
            person = mapRowToPerson(results);

        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> people = new ArrayList<>();

        if(useWildCard) {
            String sql = "SELECT * FROM person WHERE person_name ILIKE ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
            while (results.next()) {
                people.add(mapRowToPerson(results));
            }
        } else {
            String sql = "SELECT * FROM person WHERE person_name = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                people.add(mapRowToPerson(results));
            }
        }


        return people;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> people = new ArrayList<>();

        if(useWildCard) {
            String sql = "SELECT DISTINCT person_id, person_name, birthday, deathday, biography, profile_path, p.home_page FROM person p\n" +
                    "join movie_actor ma on ma.actor_id = p.person_id\n" +
                    "join movie m on m.movie_id = ma.movie_id\n" +
                    "join collection c on c.collection_id = m.collection_id\n" +
                    "where c.collection_name = ?\n" +
                    "order by person_name";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + collectionName + "%");
            while (results.next()) {
                people.add(mapRowToPerson(results));
            }
        } else {
            String sql = "SELECT DISTINCT person_id, person_name, birthday, deathday, biography, profile_path, p.home_page FROM person p\n" +
                    "join movie_actor ma on ma.actor_id = p.person_id\n" +
                    "join movie m on m.movie_id = ma.movie_id\n" +
                    "join collection c on c.collection_id = m.collection_id\n" +
                    "where c.collection_name = ?\n" +
                    "order by person_name;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);
            while (results.next()) {
                people.add(mapRowToPerson(results));
            }
        }


        return people;
    }

    private Person mapRowToPerson(SqlRowSet results) {

        Person person = new Person();

        int personId = results.getInt("person_id");
        person.setId(personId);

        String personName = results.getString("person_name");
        person.setName(personName);

        //to avoid the null pointer exception
        if(results.getDate("birthday") != null) {
            LocalDate date = results.getDate("birthday").toLocalDate();
            person.setBirthday(date);
        }
        if(results.getDate("deathday") != null) {
            LocalDate date = results.getDate("deathday").toLocalDate();
            person.setDeathDate(date);
        }

        person.setBiography(results.getString("biography"));
        person.setProfilePath(results.getString("profile_path"));
        person.setHomePage(results.getString("home_page"));

        return person;
    }
}
