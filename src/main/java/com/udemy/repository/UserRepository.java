package com.udemy.repository;

import com.udemy.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Julio on 21/03/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<Usuario,Serializable> {

    Usuario findByUsername(String username);


}
