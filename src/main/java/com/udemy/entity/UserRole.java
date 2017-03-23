package com.udemy.entity;

import javax.persistence.*;

/**
 * Created by Julio on 21/03/2017.
 */
@Entity
@Table(name="user_role", uniqueConstraints = @UniqueConstraint(columnNames ={"role","username"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name="user_role_id",unique = true,nullable = false)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username",nullable = false)
    private Usuario usuario;

    @Column(name="role",nullable = false)
    private String role;

    public UserRole(){}

    public UserRole(Usuario usuario, String role) {
        this.usuario = usuario;
        this.role = role;
    }


    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
