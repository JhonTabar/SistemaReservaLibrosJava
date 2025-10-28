package com.sistemareservalibros.service;


import com.sistemareservalibros.model.Copia;
import com.sistemareservalibros.model.Reserva;
import com.sistemareservalibros.model.Usuario;
import com.sistemareservalibros.repository.CopiaRepository;
import com.sistemareservalibros.repository.ReservaRepository;
import com.sistemareservalibros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class ReservaService {


@Autowired
private UsuarioRepository usuarioRepo;


@Autowired
private CopiaRepository copiaRepo;


@Autowired
private ReservaRepository reservaRepo;


public String reservarLibro(Integer usuarioId, Integer copiaId) {
if (!usuarioRepo.existsById(usuarioId)) {
return "El usuario no existe";
}
Optional<Copia> copiaOpt = copiaRepo.findById(copiaId);
if (copiaOpt.isEmpty()) {
return "La copia no existe";
}
if (reservaRepo.existsByCopia_Id(copiaId)) {
return "La copia ya está prestada";
}


Usuario usuario = usuarioRepo.findById(usuarioId).get();
Copia copia = copiaOpt.get();


Reserva reserva = new Reserva();
reserva.setUsuario(usuario);
reserva.setCopia(copia);
reservaRepo.save(reserva);


return "Préstamo registrado exitosamente";
}


public String devolverLibro(Integer copiaId) {
if (!copiaRepo.existsById(copiaId)) {
return "La copia no existe";
}
if (!reservaRepo.existsByCopia_Id(copiaId)) {
return "La copia no está prestada";
}
reservaRepo.deleteByCopia_Id(copiaId);
return "Devolución registrada correctamente";
}
}