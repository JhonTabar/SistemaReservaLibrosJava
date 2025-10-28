package com.sistemareservalibros.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Editorias")
public class Editoria {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDeditoria")
private Integer id;


@Column(name = "nombreEditoria", nullable = false)
private String nombreEditoria;


@Column(name = "ubicacionEditoria")
private String ubicacionEditoria;


@Column(name = "telefonoEditoria", nullable = false)
private String telefonoEditoria;


public Editoria() {}


public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public String getNombreEditoria() { return nombreEditoria; }
public void setNombreEditoria(String nombreEditoria) { this.nombreEditoria = nombreEditoria; }


public String getUbicacionEditoria() { return ubicacionEditoria; }
public void setUbicacionEditoria(String ubicacionEditoria) { this.ubicacionEditoria = ubicacionEditoria; }


public String getTelefonoEditoria() { return telefonoEditoria; }
public void setTelefonoEditoria(String telefonoEditoria) { this.telefonoEditoria = telefonoEditoria; }
}