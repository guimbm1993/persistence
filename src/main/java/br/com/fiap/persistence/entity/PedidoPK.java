package br.com.fiap.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PedidoPK implements Serializable {

    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_produto")
    private Long idProduto;


}
