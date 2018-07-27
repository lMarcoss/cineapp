package com.cine.contact.service;

import com.cine.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    private List<Contact> listContacts;

    public ContactServiceImpl() {
        this.listContacts = new ArrayList<>();
    }

    @Override
    public List<Contact> getAll() {
        return listContacts;
    }
}
