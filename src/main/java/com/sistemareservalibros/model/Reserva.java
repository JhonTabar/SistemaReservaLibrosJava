package com.sistemareservalibros.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Reservas")
public class Reserva {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IDreserva")
private Integer id;


@ManyToOne
@JoinColumn(name = "usuario_id", nullable = false)
private Usuario usuario;


@ManyToOne
@JoinColumn(name = "copias_id", nullable = false)
private Copia copia;


public Reserva() {}


public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }


public Usuario getUsuario() { return usuario; }
public void setUsuario(Usuario usuario) { this.usuario = usuario; }


public Copia getCopia() { return copia; }
public void setCopia(Copia copia) { this.copia = copia; }
}