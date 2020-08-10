package br.com.fiap.persistence.repository;

import br.com.fiap.persistence.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,Long> {


}
