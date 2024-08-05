package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.database;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(User user) {
        String sql = "INSERT INTO users (email, encrypted_password, enabled, role) VALUES (:email, :encryptedPassword, :enabled, :role)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", user.getEmail());
        params.addValue("encryptedPassword", user.getEncryptedPassword());
        params.addValue("enabled", user.getEnabled());
        params.addValue("role", user.getRole());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        List<User> users = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(User.class));
        return users.isEmpty() ? null : users.get(0);
    }
}
