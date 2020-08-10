package br.com.fiap.persistence.service;

import br.com.fiap.persistence.controller.dto.EnderecoDTO;
import br.com.fiap.persistence.entity.Endereco;

import java.util.Optional;

public interface EnderecoService {

    Endereco saveEndereco(EnderecoDTO enderecoDTO);
    Iterable<Endereco> findAll();
    Iterable<Endereco> findByIdCliente(Long idCliente);
    Optional<Endereco> findById(Long id);
    String deleteEndereco(Long id);

}
