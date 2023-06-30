package com.api.projeto.controllers;

import com.api.projeto.models.ClienteModel;
import com.api.projeto.models.ContaModel;
import com.api.projeto.repository.ContaRepository;
import com.api.projeto.response.Error;
import com.api.projeto.response.Success;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
            contaRepository.save(contaModel);
            return Success.success200(contaModel);
        } catch (Exception e) {
            return Error.error500(e);
        }
    }

    @GetMapping
    public ResponseEntity<Object> entrar(@RequestParam(value = "numero", required = false) String numeroConta, @RequestParam(value = "agencia", required = false) String agencia, @RequestParam(value = "senha", required = false) String senha) {
        try {
            if (numeroConta != null && agencia != null && senha != null) {
                ContaModel contaModel = contaRepository.findByNumeroConta(numeroConta);
                if (Objects.equals(contaModel.getNumeroConta(), numeroConta) && Objects.equals(contaModel.getAgenciaConta(), agencia) && Objects.equals(contaModel.getClienteConta().getSenhaCliente(), senha)) {
                    return Success.success200(contaModel);
                }
                return Error.error400("Conta não encontrada");
            }
            return Error.error400("Todos os parametros são obrigatórios");
        } catch (Exception e) {
            return Error.error500(e);
        }
    }
}
