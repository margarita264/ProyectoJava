package tech.blimop.grupo7.banco.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.blimop.grupo7.banco.entity.Cliente;
import tech.blimop.grupo7.banco.repository.ClienteRepository;
import tech.blimop.grupo7.banco.service.ClienteService;
import tech.blimop.grupo7.banco.service.dto.request.ClienteDTO;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;


	

	@Override
	public void deleteCliente(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
		
	}

	
	//FIXME debe implemantar ModelMapper para convertir entities en DTOs
	@Override
	public List<ClienteDTO> getClientes() {
		List<Cliente> clientes = clienteRepository.findAll();//me trae todos los clientes de la base de datos
		List<ClienteDTO> dtos= new ArrayList<ClienteDTO>();
		
		
		for (Cliente c: clientes)
		{
			ClienteDTO dto= new ClienteDTO();
			
			dto.setId(c.getId());
			dto.setDni(c.getDni());
			dto.setDomicilio(c.getDomicilio());
			dto.setEmail(c.getEmail());
			dto.setNombre(c.getNombre());
			dto.setTelefono(c.getTelefono());
			dtos.add(dto);
		}
		
		return dtos;
	}



	@Override
	public ClienteDTO add(ClienteDTO clienteDto) {
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setId(clienteDto.getId());
		nuevoCliente.setDni(clienteDto.getDni());
		nuevoCliente.setNombre(clienteDto.getNombre());
		nuevoCliente.setTelefono(clienteDto.getTelefono());
		nuevoCliente.setEmail(clienteDto.getEmail());
		nuevoCliente.setDomicilio(clienteDto.getDomicilio());
		
		nuevoCliente = clienteRepository.save(nuevoCliente);//guarda el cliente en la base de datos
		ClienteDTO dto = new ClienteDTO();
		dto.setId(nuevoCliente.getId());
		dto.setDni(nuevoCliente.getDni());
		dto.setNombre(nuevoCliente.getNombre());
		dto.setTelefono(nuevoCliente.getTelefono());
		dto.setEmail(nuevoCliente.getEmail());
		dto.setDomicilio(nuevoCliente.getDomicilio());
		
		return dto;
	}



	@Override
	public ClienteDTO update(ClienteDTO clienteDto) {
		Cliente entity = new Cliente();
		entity.setId(clienteDto.getId());
		entity.setDni(clienteDto.getDni());
		entity.setNombre(clienteDto.getNombre());
		entity.setTelefono(clienteDto.getTelefono());
		entity.setEmail(clienteDto.getEmail());
		entity.setDomicilio(clienteDto.getDomicilio());

		clienteRepository.save(entity);
		return clienteDto;
	}



	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return null;// clienteRepository.findById(id);;
	}
	
	

}
