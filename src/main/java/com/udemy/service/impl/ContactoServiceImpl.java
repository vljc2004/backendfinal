package com.udemy.service.impl;

import com.udemy.entity.Contact;

import com.udemy.repository.ContactoRepository;
import com.udemy.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Julio on 08/03/2017.
 */
@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;


    @Override
    public Contact addContact(Contact contacto) {
       return  contactoRepository.save(contacto);

    }

    @Override
    public List<Contact> listAllContact() {
        //return contactoRepository.listAllContacto();
        return contactoRepository.findAll();
        //return null;
    }

    @Override
    public void deleteContact(Long id) {
        contactoRepository.delete(id);
    }

    @Override
    public Contact busrcarPorId(Long id) {
        return contactoRepository.findById(id);
    }
}
