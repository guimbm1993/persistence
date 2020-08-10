package br.com.fiap.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity @Table(name = "tbl_pedido_produto")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PedidoProduto {

    @EmbeddedId
    private PedidoPK pedidoPK;

    @Column(name = "quantidade")
    private int quantidade;



}
