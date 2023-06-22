package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT * FROM collection;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collection = null;
        String sql = "select * from collection where collection_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next())
            collection = mapRowToCollection(results);

        return collection;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();

        if(useWildCard) {
            String sql = "SELECT * FROM collection WHERE collection_name ILIKE ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        } else {
            String sql = "SELECT * FROM collection WHERE collection_name = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                collections.add(mapRowToCollection(results));
            }
        }


        return collections;
    }

    private Collection mapRowToCollection(SqlRowSet results) {

        Collection collection = new Collection();

        int collectionId = results.getInt("collection_id");
        collection.setId(collectionId);

        String collectionName = results.getString("collection_name");
        collection.setName(collectionName);

        return collection;
    }
}
