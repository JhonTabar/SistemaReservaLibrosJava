package com.sistemareservalibros.controller;

import com.sistemareservalibros.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/prestar")
    public ResponseEntity<String> reservarLibro(@RequestParam Integer usuarioId, @RequestParam Integer copiaId) {
        String resultado = reservaService.reservarLibro(usuarioId, copiaId);
        return ResponseEntity.ok(resultado);
    }
}
