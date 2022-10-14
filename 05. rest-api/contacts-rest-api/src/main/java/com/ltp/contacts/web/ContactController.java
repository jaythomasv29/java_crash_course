package com.ltp.contacts.web;

import com.ltp.contacts.pojo.Contact;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Operation(summary="Get contact by id", description="Returns a contact based on an ID")
    @GetMapping(value = "/contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//  @ResponseBody // serialilze into JSON (The universal way to communicate with other systems)
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
            Contact contact = contactService.getContactById(id);
            return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @Operation(summary="Get all contacts within repository", description="Returns a list all contacts")
    @GetMapping(value = "/contacts/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> getContacts() {
        return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
    }
    @Operation(summary="Inserts a provided contact from Request Body into  list ", description="Returns a status code of success or failure")
    @PostMapping(value = "/contacts/add")
    public ResponseEntity<HttpStatus> createContact(@Valid @RequestBody Contact contact) {
        // save object inside repository
            contactService.saveContact(contact);
            System.out.println(contactService.getContacts().toString());
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary="Update a specific contact based on id", description="Returns an updated contact based on an ID")
    @PutMapping(value = "/contact/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @Valid @RequestBody(required = false) Contact contact)  {
        try {
            System.out.println(contactService.getContactById(id));
            contactService.updateContact(id, contact);
            return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary="Deletes a specific contact based on id", description="Returns an status code based on success/failure of deletion")
    @DeleteMapping(value = "/contact/delete/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        try {
            contactService.deleteContact(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}