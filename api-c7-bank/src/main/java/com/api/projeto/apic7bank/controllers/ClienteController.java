package com.api.projeto.apic7bank.controllers;

import com.api.projeto.apic7bank.models.ClienteModel;
import com.api.projeto.apic7bank.models.ContaModel;
import com.api.projeto.apic7bank.repository.ContaRepository;
import com.api.projeto.apic7bank.response.ErrorC7;
import com.api.projeto.apic7bank.response.Success;
import com.api.projeto.apic7bank.util.Formatters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/c7-bank/cliente")
public class ClienteController {
    private final ContaRepository contaRepository;

    public ClienteController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody ClienteModel clienteModel) {
        try {
            ContaModel contaModel = new ContaModel(clienteModel);

            clienteModel.setCpfCliente(Formatters.cpfFormatado(clienteModel.getCpfCliente()));
            contaRepository.save(contaModel);
            return Success.success200(contaModel);
        } catch (Exception e) {
            return ErrorC7.error500(e);
        }
    }

    @GetMapping
    public ResponseEntity<Object> get() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contaRepository.findAll());
        } catch (Exception e) {
            return ErrorC7.error500(e);
        }
    }
}
