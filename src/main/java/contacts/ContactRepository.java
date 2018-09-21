package contacts;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContactRepository{

    public void save(Contact contact) {
    }

    public List<Contact> getAllContacts() {
        Contact contact = new Contact();
        contact.setId((long) 124235125);
        contact.setFirstName("Elavazhagan");
        contact.setLastName("Sethuraman");
        contact.setPhoneNumber("8978808128");
        contact.setEmailAddress("esethuraman@paypal.com");

        return Arrays.asList(contact);
    }
}