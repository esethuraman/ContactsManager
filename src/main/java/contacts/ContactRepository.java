package contacts;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class ContactRepository{

    List<Contact> contacts;

    public ContactRepository(){
        contacts = new LinkedList<>();
        Contact contact = new Contact();
        contact.setId((long) 124235125);
        contact.setFirstName("Elavazhagan");
        contact.setLastName("Sethuraman");
        contact.setPhoneNumber("8978808128");
        contact.setEmailAddress("esethuraman@paypal.com");
        contacts.add(contact);
    }

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getAllContacts() {

        return contacts;
    }
}