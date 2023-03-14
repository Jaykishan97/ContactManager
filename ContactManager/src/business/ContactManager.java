package business;

import java.util.ArrayList;
import java.util.List;
import model.Contact;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                contacts.remove(c);
                break;
            }
        }
    }

    public Contact searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void editContact(String name, String phone, String email) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                c.setPhone(phone);
                c.setEmail(email);
                break;
            }
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
