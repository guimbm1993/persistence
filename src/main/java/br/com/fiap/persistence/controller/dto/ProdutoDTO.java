package br.com.fiap.persistence.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProdutoDTO {

    private Long idProduto;
    private int qtd;

}
