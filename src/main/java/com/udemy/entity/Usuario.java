package com.udemy.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Julio on 21/03/2017.
 */
@Entity
@Table(name="users")
public class Usuario {

    @Id
    @Column(name="username",unique = true,nullable = false, length = 45)
    private String username;

    @Column(name="password", nullable = false, length = 60)
    private String password;

    @Column(name="habilitado", nullable = false)
    private boolean habilitado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<UserRole>();

        public Usuario(){}

    public Usuario(String username, String password, boolean habilitado) {
        this.username = username;
        this.password = password;
        this.habilitado = habilitado;
    }

    public Usuario(String username, String password, boolean habilitado, Set<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.habilitado = habilitado;
        this.userRoles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
