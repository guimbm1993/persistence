package br.com.fiap.persistence.service;

import br.com.fiap.persistence.entity.Produto;
import br.com.fiap.persistence.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements  ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto saveProduct(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        Optional<Produto> result = produtoRepository.findById(id);
        return result;
    }

    @Override
    public String deleteProduct(Long id) {
        Optional<Produto> result = produtoRepository.findById(id);
        if(result.isPresent()){
            produtoRepository.delete(result.get());
            return "Produto deletado";
        }
        return "Não foi possível deletar";
    }

}
