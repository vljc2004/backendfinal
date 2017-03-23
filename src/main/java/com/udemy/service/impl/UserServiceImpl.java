package com.udemy.service.impl;


import com.udemy.entity.UserRole;
import com.udemy.entity.Usuario;
import com.udemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Julio on 22/03/2017.
 */

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usuario usuario = userRepository.findByUsername(s);
        List<GrantedAuthority> autorithies =  buildAuthorities(usuario.getUserRoles());
        return buildUser(usuario,autorithies);
    }


    private User buildUser(Usuario user, List<GrantedAuthority> authorities){

        return new User(user.getUsername(),user.getPassword(),user.isHabilitado(),true,true,true,authorities);

    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){

        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

        for(UserRole ur : userRoles){
            auths.add(new SimpleGrantedAuthority(ur.getRole()));
        }

        return new ArrayList<>(auths);
    }

}
