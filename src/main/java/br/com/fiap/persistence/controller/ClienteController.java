package br.com.fiap.persistence.controller;

import br.com.fiap.persistence.entity.Cliente;
import br.com.fiap.persistence.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/clients")
    public @ResponseBody
    ResponseEntity<?> salvarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }

    @GetMapping("/clients")
    public @ResponseBody ResponseEntity<?> listarClientes(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/clients/{id}")
    public  @ResponseBody ResponseEntity<?> listarPorId(@PathVariable Long id){
        return  ResponseEntity.ok().body(clienteService.findById(id));
    }

    @GetMapping("/clients/cpf/{cpf}")
    public @ResponseBody ResponseEntity<?> listarPorCPF(@PathVariable String cpf){
        return ResponseEntity.ok().body(clienteService.findByCPF(cpf));
    }

    @PutMapping("/clients")
    public @ResponseBody ResponseEntity<?> alterarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }

    @DeleteMapping("/clients/{id}")
    public @ResponseBody ResponseEntity<?> deletarCliente(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteService.deleteCliente(id));
    }


}
