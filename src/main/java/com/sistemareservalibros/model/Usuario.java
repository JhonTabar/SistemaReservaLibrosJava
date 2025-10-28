package com.sistemareservalibros.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Usuarios")
public class Usuario {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDusuario")
private Integer id;


@Column(name = "nombreUsuario", nullable = false, unique = true)
private String nombreUsuario;


@Column(name = "emailUsuario", nullable = false)
private String emailUsuario;


@Column(name = "telefono")
private String telefono;


public Usuario() {}


public Usuario(Integer id, String nombreUsuario, String emailUsuario) {
this.id = id;
this.nombreUsuario = nombreUsuario;
this.emailUsuario = emailUsuario;
}


public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public String getNombreUsuario() { return nombreUsuario; }
public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }


public String getEmailUsuario() { return emailUsuario; }
public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }


public String getTelefono() { return telefono; }
public void setTelefono(String telefono) { this.telefono = telefono; }
}