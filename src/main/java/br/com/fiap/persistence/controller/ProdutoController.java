package br.com.fiap.persistence.controller;

import br.com.fiap.persistence.entity.Produto;
import br.com.fiap.persistence.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/products")
    public @ResponseBody
    ResponseEntity<?> salvarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.saveProduct(produto));
    }

    @GetMapping("/products")
    public @ResponseBody ResponseEntity<?> listarTodos(){
        return  ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping("/products/{id}")
    public @ResponseBody ResponseEntity<?> listarProduto(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @DeleteMapping("/products/{id}")
    public @ResponseBody ResponseEntity<?> deletarProduto(@PathVariable Long id){
        return  ResponseEntity.ok().body(produtoService.deleteProduct(id));
    }

    @PutMapping("/products")
    public  @ResponseBody ResponseEntity<?> atualizarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.saveProduct(produto));
    }

}
