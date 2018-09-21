package contacts.controller;

import contacts.persistence.ContactRepository;
import contacts.domain.Contact;
import contacts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController{

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model){
        List<Contact> allContacts = contactRepository.getAllContacts();
        model.put("allContacts", allContacts);
        model.put("currentUser", userRepository.getCurrentUser());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact){
        contactRepository.save(contact);
        return "redirect:/contacts";
    }
}