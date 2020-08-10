package br.com.fiap.persistence.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PedidoDTO {

    private Long idCliente;
    private Long idEndereco;
    private List<ProdutoDTO> produtos;

}
