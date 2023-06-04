package com.api.projeto.controllers;

import com.api.projeto.models.ClienteModel;
import com.api.projeto.models.ContaModel;
import com.api.projeto.repository.ClienteRepository;
import com.api.projeto.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/c7-bank/cliente")
public class ClienteController {
    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ClienteController(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody ClienteModel clienteModel) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contaRepository.save(new ContaModel(clienteModel)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível salvar o usuário: " + e);
        }
    }

    @PutMapping
    public ResponseEntity<Object> adicionarValor(@RequestParam Integer id, @RequestParam double value) {
        try {

            Optional<ClienteModel> clienteModel = clienteRepository.findById(id);

            if (clienteModel.isPresent()) {
                double novoValor = clienteModel.get().getContaCliente().getSaldoConta() + value;
                return ResponseEntity.status(HttpStatus.OK).body("Novo valor da conta de " + clienteModel.get().getNomeCliente() + " é: " + novoValor);
            }

            return ResponseEntity.status(HttpStatus.OK).body("Cliente não encontrado");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível adicionar o valor: " + e);
        }
    }
}
