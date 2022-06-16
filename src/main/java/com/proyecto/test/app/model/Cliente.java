package com.proyecto.test.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotEmpty
    @Column(name="nombre")
    private String nombre;
    @NotEmpty
    @Column(name="apellido")
    private String apellido;
    @NotEmpty
    @Email
    @Column(name="email")
    private String email;
    @NotEmpty
    @Column(name="username")
    private String username;
    @NotEmpty
    @Column(name="passwd")
    private String passwd;
    private static final long serialVersionUID = 1L;
    @Column(name="roles")
    private String roles;
    
    
    public Cliente() {}

    public Cliente(String nombre, String apellido, String email, String username, String passwd, String roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.passwd = passwd;
        this.roles = roles;
    }
    
    public Cliente(Long id, String nombre, String apellido, String email, String username, String passwd) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.passwd = passwd;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    

}
