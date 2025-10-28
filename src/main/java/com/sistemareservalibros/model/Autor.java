package com.sistemareservalibros.model;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Autores")
public class Autor {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDautor")
private Integer id;


@Column(name = "nombreAutor", nullable = false, unique = true)
private String nombreAutor;


@Column(name = "nacimientoAutor")
private LocalDate nacimientoAutor;


public Autor() {}


public Autor(Integer id, String nombreAutor, LocalDate nacimientoAutor) {
this.id = id;
this.nombreAutor = nombreAutor;
this.nacimientoAutor = nacimientoAutor;
}


public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public String getNombreAutor() { return nombreAutor; }
public void setNombreAutor(String nombreAutor) { this.nombreAutor = nombreAutor; }


public LocalDate getNacimientoAutor() { return nacimientoAutor; }
public void setNacimientoAutor(LocalDate nacimientoAutor) { this.nacimientoAutor = nacimientoAutor; }
}