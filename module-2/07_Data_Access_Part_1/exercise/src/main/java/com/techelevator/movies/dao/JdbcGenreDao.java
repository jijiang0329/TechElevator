package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genre;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            genres.add(mapRowToGenre(results));
        }
        return genres;
    }

    @Override
    public Genre getGenreById(int id) {
        Genre genre = null;
        String sql = "select * from genre where genre_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next())
            genre = mapRowToGenre(results);

        return genre;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> genres = new ArrayList<>();

        if(useWildCard) {
            String sql = "SELECT * FROM genre WHERE genre_name LIKE ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
            while (results.next()) {
                genres.add(mapRowToGenre(results));
            }
        } else {
            String sql = "SELECT * FROM genre WHERE genre_name = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                genres.add(mapRowToGenre(results));
            }
        }


        return genres;
    }
    private Genre mapRowToGenre(SqlRowSet results) {

        Genre genre = new Genre();

        int genreId = results.getInt("genre_id");
        genre.setId(genreId);

        String genreName = results.getString("genre_name");
        genre.setName(genreName);

        return genre;
    }
}
