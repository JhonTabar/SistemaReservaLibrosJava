package com.sistemareservalibros.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Libros")
public class Libro {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDlibro")
private Integer id;


@Column(name = "tituloLibro", nullable = false)
private String tituloLibro;


@Column(name = "fechaPublicacion", nullable = false)
private LocalDate fechaPublicacion;


@Column(name = "lenguaje", nullable = false)
private String lenguaje;


@ManyToOne
@JoinColumn(name = "autor_id", nullable = false)
private Autor autor;


@ManyToOne
@JoinColumn(name = "editoria_id", nullable = false)
private Editoria editoria;


@ManyToOne
@JoinColumn(name = "genero_id", nullable = false)
private Genero genero;


// Constructors
public Libro() {}


// Getters & Setters
public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public String getTituloLibro() { return tituloLibro; }
public void setTituloLibro(String tituloLibro) { this.tituloLibro = tituloLibro; }


public LocalDate getFechaPublicacion() { return fechaPublicacion; }}