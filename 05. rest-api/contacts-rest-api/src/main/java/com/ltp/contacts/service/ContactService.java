package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

import java.util.List;
import java.util.NoSuchElementException;

public interface ContactService {

  Contact getContactById(String id) throws NoSuchElementException;
  List<Contact> getContacts();
  void saveContact(Contact contact);

  void updateContact(String id, Contact contact) throws NoSuchElementException;

  void deleteContact(String id) throws NoSuchElementException;
    
}
