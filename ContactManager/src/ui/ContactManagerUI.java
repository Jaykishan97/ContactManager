package ui;

import java.util.Scanner;
import business.ContactManager;
import model.Contact;

public class ContactManagerUI {
    private ContactManager contactManager;
    private Scanner input;

    public ContactManagerUI() {
        contactManager = new ContactManager();
        input = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            System.out.println("Contact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. List Contacts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                    listContacts();
                    break;
                case 6:
                    System.out.println("Exiting Contact Manager...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter phone number: ");
        String phone = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        Contact contact = new Contact(name, phone, email);
        contactManager.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private void deleteContact() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        contactManager.deleteContact(name);
        System.out.println("Contact deleted successfully.");
    }

    private void searchContact() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        Contact contact = contactManager.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found:\n" + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void editContact() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter new phone number: ");
        String phone = input.nextLine();
        System.out.print("Enter new email: ");
        String email = input.nextLine();
        contactManager.editContact(name, phone, email);
        System.out.println("Contact edited successfully.");
    }

    private void listContacts() {
        System.out.println("Contacts:\n");
        for (Contact contact : contactManager.getContacts()) {
            System.out.println(contact + "\n");
        }
    }
}
