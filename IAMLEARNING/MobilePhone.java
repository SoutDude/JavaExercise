package IAMLEARNING;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String MyNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();

    }

    public boolean addNewContact(Contact contact ){
        if(findContact(contact.getName()) >=0 ) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact NewContact){
        
        // checking "oldContact or existing contact and returning "oldContact.getName" so this way we can store it in memory in this
        // block of code so that we can exchange it and produce what we are seeking for, which is update current conctact with new creditials.
        // we are requesting the position verifying that this index exists while returning false only to have getname so we can exchange when it is true!
        int foundPosition = findContact(oldContact);
        if(foundPosition <0 ) {
            System.out.println(oldContact.getName() + ", was not found. ");
            return false;
        
            // This action below "else if" checking to see if contact already exsist and because it has "!= -1" which indicates that
            // this is false and contact does exists!.. if so it won't create a duplicate when 
            // trying to update the contact with the same creditials and returning false! because our end goal is to update 
            // contact to a new name and to produce a return true;
        } else if(findContact(NewContact.getName()) != -1) {
            System.out.println("Contact with name " + NewContact.getName() +
                    "already exists. update was not successful. ");
            return false;
        }

        this.myContacts.set(foundPosition, NewContact);
        System.out.println(oldContact.getName() + ", was replaced with " + NewContact.getName());
        return true;

    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted. ");
        return true;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName ){
        for(int i=0; i<this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;

    }


    public String queryContact(Contact contact){
        if(findContact(contact) >=0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contct List");
        for(int i=0; i<this.myContacts.size(); i++) {
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }





}
