package com.sistemareservalibros.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Copias")
public class Copia {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDcopia")
private Integer id;


@ManyToOne
@JoinColumn(name = "libro_id", nullable = false)
private Libro libro;


@Column(name = "codigoBarra", nullable = false, unique = true)
private String codigoBarra;


@Column(name = "ubicacion")
private String ubicacion;


public Copia() {}


public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public Libro getLibro() { return libro; }
public void setLibro(Libro libro) { this.libro = libro; }


public String getCodigoBarra() { return codigoBarra; }
public void setCodigoBarra(String codigoBarra) { this.codigoBarra = codigoBarra; }


public String getUbicacion() { return ubicacion; }
public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}
