package br.com.fiap.persistence.controller.dto;

import br.com.fiap.persistence.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class EnderecoDTO {

    private Long idEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private Long idCliente;
}
