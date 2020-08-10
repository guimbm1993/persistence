package br.com.fiap.persistence.service;

import br.com.fiap.persistence.controller.dto.PedidoDTO;
import br.com.fiap.persistence.controller.dto.ProdutoDTO;
import br.com.fiap.persistence.entity.*;
import br.com.fiap.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoProdutoRepository pedidoProdutoRepository;

    @Override
    public Pedido savePedido(PedidoDTO pedidoDTO) {

        Pedido pedido = new Pedido();

        Cliente cliente = clienteRepository.findById(pedidoDTO.getIdCliente())
                .orElseThrow(()->new RuntimeException("Cliente não encontrado"));
        Endereco endereco = enderecoRepository.findById(pedidoDTO.getIdEndereco())
                .orElseThrow(()-> new RuntimeException("Endereço não encontrado") );

        List<Produto> produtoList = new ArrayList<>();


        for(ProdutoDTO auxDTO: pedidoDTO.getProdutos()){
            Optional<Produto> produtoAux = produtoRepository.findById(auxDTO.getIdProduto());
            if(produtoAux.isPresent()){
                produtoList.add(produtoAux.get());
                //atualizar estoque
                int qtdEstoque = produtoAux.get().getQuantidade() - auxDTO.getQtd();
                if(qtdEstoque > 0){
                    produtoAux.get().setQuantidade(qtdEstoque);
                    produtoRepository.save(produtoAux.get());
                }else{
                    throw  new RuntimeException("Quantidade do produto: " + produtoAux.get().getNome() + "indisp.");
                }

            }
            pedido.setCliente(cliente);
            pedido.setEndereco(endereco);
            pedido.setData(new Date());
            pedidoRepository.save(pedido);
            PedidoPK pedidoPK = new PedidoPK();
            pedidoPK.setIdPedido(pedido.getIdPedido());
            pedidoPK.setIdProduto(produtoAux.get().getIdProduto());
            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setPedidoPK(pedidoPK);
            pedidoProduto.setQuantidade(auxDTO.getQtd());
            pedidoProdutoRepository.save(pedidoProduto);
        }

        return pedido;
    }

    @Override
    public Iterable<Pedido> findAll() {

        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        Optional<Pedido> result = pedidoRepository.findById(id);
        return result;
    }

    @Override
    public String deletePedido(Long idPedido) {
        Optional<Pedido> result = pedidoRepository.findById(idPedido);
        if(result.isPresent()){
            List<PedidoProduto> pedidoProdutoList = pedidoProdutoRepository.findAll();
            pedidoProdutoList.stream()
                    .filter(registro -> registro.getPedidoPK().getIdPedido() == result.get().getIdPedido())
                    .collect(Collectors.toList());
            pedidoProdutoRepository.deleteAll(pedidoProdutoList);
            pedidoRepository.delete(result.get());
            return "Pedido deletado";
        }
        return "Não foi possível deletar";
    }

    @Override
    public List<String> findItensOrder(Long idPedido) {

        List<String> result = new ArrayList<>();
        List<PedidoProduto> pedidoProdutoList = pedidoProdutoRepository.findAll();
        pedidoProdutoList.stream()
                .filter(registro -> registro.getPedidoPK().getIdPedido() == idPedido)
                .collect(Collectors.toList());
        for(PedidoProduto pedidoProdutoAux: pedidoProdutoList){
           Optional<Produto> produtoAux = produtoRepository.findById(pedidoProdutoAux.getPedidoPK().getIdProduto());
           if(produtoAux.isPresent()){
               result.add(produtoAux.get().getNome() + " - " +
                       " QTD: " + String.valueOf(pedidoProdutoAux.getQuantidade()));
           }
        }
        return result;
    }
}
