package br.com.fiap.persistence.service;

import br.com.fiap.persistence.entity.Produto;

import java.util.Optional;

public interface ProdutoService {

    Produto saveProduct(Produto produto);
    Iterable<Produto> findAll();
    Optional<Produto> findById(Long id);
    String deleteProduct(Long id);

}
