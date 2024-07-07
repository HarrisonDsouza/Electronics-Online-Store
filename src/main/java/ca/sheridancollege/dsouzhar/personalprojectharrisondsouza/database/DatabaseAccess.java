package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.Electronic;

import java.util.List;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    // Fetch all products
    public List<Electronic> getProductsList() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM ELECTRONICS";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Electronic>(Electronic.class));
    }

    // Add a new product
    public void insertProduct(Electronic product) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("imageUrl", product.getImageUrl());
        namedParameters.addValue("productName", product.getProductName());
        namedParameters.addValue("productDesc", product.getProductDesc());
        namedParameters.addValue("price", product.getPrice());
        String query = "INSERT INTO ELECTRONICS (imageUrl, productName, productDesc, price) VALUES (:imageUrl, :productName, :productDesc, :price)";
        jdbc.update(query, namedParameters);
    }

    // Update an existing product
    public void editProduct(Electronic product) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", product.getId());
        namedParameters.addValue("imageUrl", product.getImageUrl());
        namedParameters.addValue("productName", product.getProductName());
        namedParameters.addValue("productDesc", product.getProductDesc());
        namedParameters.addValue("price", product.getPrice());
        String query = "UPDATE ELECTRONICS SET imageUrl = :imageUrl, productName = :productName, " +
        "productDesc = :productDesc, price = :price WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "DELETE FROM ELECTRONICS WHERE id = :id";
        jdbc.update(query, namedParameters);
    }

    // Retrieve a product by ID
    public List<Electronic> getProductById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        String query = "SELECT * FROM ELECTRONICS WHERE id = :id";
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Electronic.class));
    }
}
