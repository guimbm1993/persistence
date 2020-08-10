package br.com.fiap.persistence.controller;

import br.com.fiap.persistence.controller.dto.PedidoDTO;
import br.com.fiap.persistence.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/orders")
    public @ResponseBody
    ResponseEntity<?> salvarPedido(@RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.ok().body(pedidoService.savePedido(pedidoDTO));
    }

    @GetMapping("/orders")
    public @ResponseBody ResponseEntity<?> listarPedidos(){

        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping("/itens/order/{idPedido}")
    public @ResponseBody ResponseEntity<?> listarItensPedido(@PathVariable Long idPedido){
        return ResponseEntity.ok().body(pedidoService.findItensOrder(idPedido));
    }

    @GetMapping("/orders/{id}")
    public @ResponseBody ResponseEntity<?> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @DeleteMapping("orders/{id}")
    public @ResponseBody ResponseEntity<?> deletarPedido(@PathVariable Long id){
        return ResponseEntity.ok().body(pedidoService.deletePedido(id));
    }

}
