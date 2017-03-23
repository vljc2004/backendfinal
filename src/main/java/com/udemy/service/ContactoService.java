package com.udemy.service;

import com.udemy.entity.Contact;

import java.util.List;

/**
 * Created by Julio on 08/03/2017.
 */
public interface ContactoService {

    Contact addContact(Contact contacto);
    List<Contact> listAllContact();
    void deleteContact(Long id);
    Contact busrcarPorId(Long id);
}
