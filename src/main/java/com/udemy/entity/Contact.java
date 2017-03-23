package com.udemy.entity;

import javax.persistence.*;

/**
 * Created by Julio on 07/03/2017.
 */
@Entity
@Table(name="contacto")
public class Contact {

    @Id
    @GeneratedValue
    @Column(name="id_contacto")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="materno")
    private String materno;
    @Column(name="telefono")
    private String telefono;
    @Column(name="ciudad")
    private String ciudad;


    public Contact(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Contact(String nombre, String materno, String telefono, String ciudad) {
        this.nombre = nombre;
        this.materno = materno;
        this.telefono = telefono;
        this.ciudad = ciudad;

    }

    public String getNombre() {
        return nombre;
    }

    public String getMaterno() {
        return materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", materno='" + materno + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
