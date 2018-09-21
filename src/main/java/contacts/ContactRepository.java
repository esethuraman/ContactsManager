package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class ContactRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Contact> contacts;

    public void save(Contact contact) {
        jdbcTemplate.update(
                "INSERT INTO contacts " +
                        "(firstName, lastName, phoneNumber, emailAddress)" +
                        "VALUES(?, ?, ?, ?)",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getEmailAddress()
                );
    }

    public List<Contact> getAllContacts() {

        return jdbcTemplate.query(
                "SELECT id, firstName, lastName, phoneNumber, emailAddress " +
                        "FROM contacts ORDER BY firstName",
                new RowMapper<Contact>() {
                    @Override
                    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
                        Contact contact = new Contact();

                        contact.setId(resultSet.getLong(1));
                        contact.setFirstName(resultSet.getString(2));
                        contact.setLastName(resultSet.getString(3));
                        contact.setPhoneNumber(resultSet.getString(4));
                        contact.setEmailAddress(resultSet.getString(5));

                        return contact;
                    }
                }
        );
    }
}