package tech.blimop.grupo7.banco.service;

import java.util.List;

import tech.blimop.grupo7.banco.entity.Cliente;
import tech.blimop.grupo7.banco.service.dto.request.ClienteDTO;


public interface ClienteService {

	ClienteDTO add(ClienteDTO clienteDto);
	
	ClienteDTO update(ClienteDTO clienteDto);
		
	Cliente findById(Long id);
	
	List<ClienteDTO> getClientes();
	
	
	void deleteCliente(Long id);

}