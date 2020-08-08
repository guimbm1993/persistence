package br.com.fiap.persistence.service;

import br.com.fiap.persistence.entity.Cliente;
import br.com.fiap.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Optional<Cliente> result = clienteRepository.findById(id);
        return result;
    }

    @Override
    public String deleteCliente(Long id) {
        Optional<Cliente> result = clienteRepository.findById(id);
        if(result.isPresent()){
            clienteRepository.delete(result.get());
            return "Cliente deletado";
        }
        return "Não foi possível deletar";
    }

    @Override
    public Cliente findByCPF(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}
