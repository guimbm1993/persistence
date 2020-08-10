package br.com.fiap.persistence.controller;

import br.com.fiap.persistence.controller.dto.EnderecoDTO;
import br.com.fiap.persistence.service.ClienteService;
import br.com.fiap.persistence.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    ClienteService clienteService;

    @PostMapping("/address")
    public @ResponseBody
    ResponseEntity<?> salvarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok().body(enderecoService.saveEndereco(enderecoDTO));
    }

    @GetMapping("/address")
    public @ResponseBody ResponseEntity<?> listarEnderecos(){
        return ResponseEntity.ok().body(enderecoService.findAll());
    }

    @GetMapping("/address/{id}")
    public @ResponseBody ResponseEntity<?> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(enderecoService.findById(id));
    }

    @GetMapping("/clients/address/{idCliente}")
    public @ResponseBody ResponseEntity<?> listarPorIdCliente(@PathVariable Long idCliente){
        return ResponseEntity.ok().body(enderecoService.findByIdCliente(idCliente));
    }

    @PutMapping("/address")
    public @ResponseBody ResponseEntity<?> atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok().body(enderecoService.saveEndereco(enderecoDTO));
    }

    @DeleteMapping("/address/{id}")
    public @ResponseBody ResponseEntity<?> deletarEndereco(@PathVariable Long id){
        return ResponseEntity.ok().body(enderecoService.deleteEndereco(id));
    }


}
