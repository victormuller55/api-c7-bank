package com.api.projeto.controllers;

import com.api.projeto.models.ClienteModel;
import com.api.projeto.models.ContaModel;
import com.api.projeto.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/c7-bank/cliente")
public class ClienteController {
    private final ContaRepository contaRepository;
    public ClienteController(ContaRepository contaRepository) { this.contaRepository = contaRepository; }
    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody ClienteModel clienteModel) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contaRepository.save(new ContaModel(clienteModel)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível salvar o usuário: " + e);
        }
    }
}
