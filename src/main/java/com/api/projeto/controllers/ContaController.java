package com.api.projeto.controllers;

import com.api.projeto.models.ContaModel;
import com.api.projeto.repository.ClienteRepository;
import com.api.projeto.repository.ContaRepository;
import com.api.projeto.response.Error;
import com.api.projeto.response.Success;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class ContaController {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    public ContaController(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    @PutMapping()
    @RequestMapping("/v1/c7-bank/conta/adicionarSaldo")
    public ResponseEntity<Object> adicionarSaldo(@RequestParam(value = "conta", required = false) String numeroConta, @RequestParam(value = "valor", required = false) Double valor) {
        try {
            if (numeroConta != null && valor != null) {
                ContaModel contaModel = contaRepository.findByNumeroConta(numeroConta);
                if (contaModel != null) {
                    contaModel.setSaldoConta(contaModel.getSaldoConta() + valor);
                    contaRepository.save(contaModel);

                    return Success.success200(contaModel.getSaldoConta());
                }
                return Error.error400("Conta não encontrada");
            } else {
                return Error.error400("Os parametros 'conta' e 'valor' são obrigatório");
            }
        } catch (Exception e) {
            return Error.error500(e);
        }
    }

    @PutMapping()
    @RequestMapping("/v1/c7-bank/conta/pagarBoleto")
    public ResponseEntity<Object> pagar(@RequestParam(value = "conta", required = false) String numeroConta, @RequestParam(value = "valor", required = false) Double boletoValor) {
        try {
            if (numeroConta != null && boletoValor != null) {
                ContaModel contaModel = contaRepository.findByNumeroConta(numeroConta);
                if (contaModel != null) {
                    if (contaModel.getSaldoConta() >= boletoValor) {

                        contaModel.setSaldoConta(contaModel.getSaldoConta() - boletoValor);
                        contaRepository.save(contaModel);

                        return Success.success200(contaModel.getSaldoConta());
                    }
                    return Error.error400("Saldo insuficiente");
                }
                return Error.error400("Conta não encontrada");
            }
            return Error.error400("Os parametros 'numeroConta' e 'boletoValor' são obrigatório");
        } catch (Exception e) {
            return Error.error500(e);
        }
    }

    @PutMapping()
    @RequestMapping("/v1/c7-bank/conta/tranferir")
    public ResponseEntity<Object> tranferir(@RequestParam(value = "contaOrigem", required = false) String numeroContaOrigem, @RequestParam(value = "contaReceber", required = false) String numeroContaReceber, @RequestParam(value = "valor", required = false) Double valor) {
        try {
            if (numeroContaOrigem != null && numeroContaReceber != null && valor != null) {

                String numeroConta;

                numeroConta = numeroContaOrigem;
                ContaModel contaOrigem = contaRepository.findByNumeroConta(numeroConta);
                numeroConta = numeroContaReceber;
                ContaModel contaReceber = contaRepository.findByNumeroConta(numeroConta);

                if (contaOrigem != null && contaReceber != null) {
                    if (contaOrigem.getSaldoConta() >= valor) {

                        contaOrigem.setSaldoConta(contaOrigem.getSaldoConta() - valor);
                        contaReceber.setSaldoConta(contaReceber.getSaldoConta() + valor);
                        contaRepository.save(contaOrigem);
                        contaRepository.save(contaReceber);

                        return Success.success200(contaOrigem.getSaldoConta());
                    }
                    return Error.error400("Saldo insuficiente para tranferencia");
                }
                return Error.error400("Conta não encontrada");
            }
            return Error.error400("Os parametros 'contaOrigem', 'contaReceber' e 'valor' são obrigatório");
        } catch (Exception e) {
            return Error.error500(e);
        }
    }

    @PutMapping()
    @RequestMapping("/v1/c7-bank/conta/pix")
        public ResponseEntity<Object> pix(@RequestParam(value = "contaOrigem", required = false) String numeroConta, @RequestParam(value = "cpf", required = false) String cpfCliente, @RequestParam(value = "valor", required = false) Double valor) {
        try {
            if (numeroConta != null && cpfCliente != null && valor != null) {

                ContaModel contaOrigem = contaRepository.findByNumeroConta(numeroConta);
                ContaModel contaReceber = clienteRepository.findByCpfCliente(cpfCliente).getContaCliente();

                if (contaOrigem != null && contaReceber != null) {
                    if (contaOrigem.getSaldoConta() >= valor) {

                        contaOrigem.setSaldoConta(contaOrigem.getSaldoConta() - valor);
                        contaReceber.setSaldoConta(contaReceber.getSaldoConta() + valor);
                        contaRepository.save(contaOrigem);
                        contaRepository.save(contaReceber);

                        return Success.success200(contaOrigem.getSaldoConta());
                    }
                    return Error.error400("Saldo insuficiente para tranferencia");
                }
                return Error.error400("Conta não encontrada");
            }
            return Error.error400("Os parametros 'contaOrigem', 'contaReceber' e 'valor' são obrigatório");
        } catch (Exception e) {
            return Error.error500(e);
        }
    }
}
