package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) {
        //Step 1 - declare what we want to return
        Movie movie = null;

        //Step 2 - write the sql and save it as a string
        String sql = "select * from movie where movie_id = ?;";

        //Step 3 - send the sql to the database and store the results
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        //Step 4 - convert database results to java objects
        while(results.next()){
            movie = mapRowToMovie(results);
        }

        //Step 5 = return value
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();

        if(useWildCard) {
            String sql = "SELECT * FROM movie WHERE title ILIKE ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + title + "%");
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } else {
            String sql = "SELECT * FROM movie WHERE title ILIKE ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        }


        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear,
           int endYear, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();

        if(useWildCard) {
            String sql = "select * from movie join person on person.person_id = movie.director_id\n" +
                    "where person_name like ? and extract(year from release_date) >= ? and extract(year from release_date) <= ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + directorName + "%", startYear, endYear);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        } else {
            String sql = "select * from movie join person on person.person_id = movie.director_id\n" +
                    "where person_name = ? and extract(year from release_date) >= ? and extract(year from release_date) <= ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, directorName, startYear, endYear);
            while (results.next()) {
                movies.add(mapRowToMovie(results));
            }
        }


        return movies;
    }
    private Movie mapRowToMovie(SqlRowSet results) {

        Movie movie = new Movie();

        int movieId = results.getInt("movie_id");
        movie.setId(movieId);

        String movieTitle = results.getString("title");
        movie.setTitle(movieTitle);

        String overview = results.getString("overview");
        movie.setOverview(overview);

        String movieTagline = results.getString("tagline");
        movie.setTagline(movieTagline);

        String posterPath = results.getString("poster_path");
        movie.setPosterPath(posterPath);

        String homePage = results.getString("home_page");
        movie.setHomePage(homePage);

        //to avoid the null pointer exception
        if(results.getDate("release_date") != null) {
            LocalDate date = results.getDate("release_date").toLocalDate();
            movie.setReleaseDate(date);
        }

        int length = results.getInt("length_minutes");
        movie.setLengthMinutes(length);

        int directorId = results.getInt("director_id");
        movie.setDirectorId(directorId);

        int collectionId = results.getInt("collection_id");
        movie.setCollectionId(collectionId);

        return movie;
    }
}
