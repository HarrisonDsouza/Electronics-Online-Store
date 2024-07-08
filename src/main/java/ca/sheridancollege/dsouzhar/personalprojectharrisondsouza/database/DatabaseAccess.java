package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.Electronic;
import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.Review;

import java.util.List;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    // Fetch all products
    public List<Electronic> getProductsList() {
        String query = "SELECT e.*, COALESCE(r.avg_rating, 0) AS rating " +
                       "FROM ELECTRONICS e " +
                       "LEFT JOIN (SELECT productId, AVG(reviewScore) AS avg_rating FROM REVIEWS GROUP BY productId) r " +
                       "ON e.id = r.productId";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Electronic.class));
    }

    // Add a new product
    public void insertProduct(Electronic product) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("productName", product.getProductName());
        namedParameters.addValue("productDesc", product.getProductDesc());
        namedParameters.addValue("price", product.getPrice());
        String query = "INSERT INTO ELECTRONICS (productName, productDesc, price) VALUES (:productName, :productDesc, :price)";
        jdbc.update(query, namedParameters);
    }

    // Update an existing product
    public void editProduct(Electronic product) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", product.getId());
        namedParameters.addValue("productName", product.getProductName());
        namedParameters.addValue("productDesc", product.getProductDesc());
        namedParameters.addValue("price", product.getPrice());
        String query = "UPDATE ELECTRONICS SET productName = :productName, productDesc = :productDesc, price = :price WHERE id = :id";
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

    // Add a review for a product
    public void addReview(Review review) {
        String query = "INSERT INTO REVIEWS (productId, userName, userEmail, reviewScore) VALUES (:productId, :userName, :userEmail, :reviewScore)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("productId", review.getProductId());
        namedParameters.addValue("userName", review.getUserName());
        namedParameters.addValue("userEmail", review.getUserEmail());
        namedParameters.addValue("reviewScore", review.getReviewScore());
        jdbc.update(query, namedParameters);

        updateProductRating(review.getProductId());
    }

    // Update product rating based on reviews
    private void updateProductRating(Long productId) {
        String updateQuery = "UPDATE ELECTRONICS e SET rating = (SELECT AVG(reviewScore) FROM REVIEWS WHERE productId = :productId) WHERE e.id = :productId";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource().addValue("productId", productId);
        jdbc.update(updateQuery, namedParameters);
    }

    public List<Review> getReviewsByProductId(Long productId) {
        String query = "SELECT * FROM reviews WHERE productId = :productId";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("productId", productId);
        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Review.class));
    }
}
