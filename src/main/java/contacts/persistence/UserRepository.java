package contacts.persistence;

import contacts.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private User currentUser;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO users " +
                "(userName, password) " +
                        "values(?, ?)",
                user.getUserName(),
                user.getPassword()
        );

        // assigning the user for printing in the contacts page
        this.currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }
}
