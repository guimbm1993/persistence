package br.com.fiap.persistence.service;

import br.com.fiap.persistence.controller.dto.PedidoDTO;
import br.com.fiap.persistence.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    Pedido savePedido(PedidoDTO pedidoDTO);
    Iterable<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    String deletePedido(Long idPedido);
    List<String> findItensOrder(Long idPedido);

}
