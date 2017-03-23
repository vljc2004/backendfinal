package com.udemy.repository;

import com.udemy.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Julio on 07/03/2017.
 */

@Repository
public interface ContactoRepository extends JpaRepository<Contact,Long> {

    //List<Contact> findAllContact();

    Contact findById(Long id);
}
