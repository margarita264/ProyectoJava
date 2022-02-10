package tech.blimop.grupo7.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.blimop.grupo7.banco.entity.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository <Cliente, Long>{
	
	Cliente findByDni(String dni);
	
	List<Cliente>findAll();
	//holaa
	
	
}
