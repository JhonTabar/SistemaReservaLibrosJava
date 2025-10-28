package com.sistemareservalibros.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Genero")
public class Genero {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDgenero")
private Integer id;


@Column(name = "nombreCategorGenero", nullable = false, unique = true)
private String nombreCategorGenero;


public Genero() {}


public Genero(Integer id, String nombre) {
this.id = id;
this.nombreCategorGenero = nombre;
}


public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public String getNombreCategorGenero() { return nombreCategorGenero; }
public void setNombreCategorGenero(String nombreCategorGenero) { this.nombreCategorGenero = nombreCategorGenero; }
}