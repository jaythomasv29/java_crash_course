package com.ltp.contacts.web;

import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

//@Controller
//@ResponseBody
@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
//  @ResponseBody // serialilze into JSON (The universal way to communicate with other systems)
    public ResponseEntity<Contact> getContact(@PathVariable String id) {

            Contact contact = contactService.getContactById(id);
            return new ResponseEntity<>(contact, HttpStatus.OK);


    }

    @GetMapping("/contacts/all")
    public ResponseEntity<List<Contact>> getContacts() {
        return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
    }

    @PostMapping("/contacts/add")
    // method to deserialize json
    public ResponseEntity<HttpStatus> createContact(@Valid @RequestBody Contact contact) {
        // save object inside repository
            contactService.saveContact(contact);
            System.out.println(contactService.getContacts().toString());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Edit a specific contact based on id
    @PutMapping("/contact/update/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @Valid @RequestBody(required = false) Contact contact)  {
        try {
            System.out.println(contactService.getContactById(id));
            contactService.updateContact(id, contact);
            return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/contact/delete/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        try {
            contactService.deleteContact(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
