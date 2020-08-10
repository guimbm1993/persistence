package br.com.fiap.persistence.service;

import br.com.fiap.persistence.controller.dto.EnderecoDTO;
import br.com.fiap.persistence.entity.Cliente;
import br.com.fiap.persistence.entity.Endereco;
import br.com.fiap.persistence.repository.ClienteRepository;
import br.com.fiap.persistence.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Endereco saveEndereco(EnderecoDTO enderecoDTO) {

        Cliente cliente = clienteRepository.findById(enderecoDTO.getIdCliente())
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
        Endereco endereco = new Endereco();
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setCliente(cliente);
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setPais(enderecoDTO.getPais());
        if(enderecoDTO.getIdEndereco() == null){
            endereco.setIdEndereco(0L);
        }else{
            endereco.setIdEndereco(enderecoDTO.getIdEndereco());
        }

        return enderecoRepository.save(endereco);
    }

    @Override
    public Iterable<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Iterable<Endereco> findByIdCliente(Long idCliente) {
        List<Endereco> listEnderecos = (List<Endereco>) enderecoRepository.findAll();
        return listEnderecos.stream().filter(registro -> registro.getCliente().getIdCliente() == idCliente)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Endereco> findById(Long id) {
        Optional<Endereco> result = enderecoRepository.findById(id);
        return result;
    }

    @Override
    public String deleteEndereco(Long id) {
        Optional<Endereco> result = enderecoRepository.findById(id);
        if(result.isPresent()){
            enderecoRepository.delete(result.get());
            return "Endereço deletado";
        }
        return "Não foi possível deletar";
    }
}
