package tech.blimop.grupo7.banco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tech.blimop.grupo7.banco.service.ClienteService;
import tech.blimop.grupo7.banco.service.dto.request.ClienteDTO;

@RestController
@RequestMapping("/api/cliente")
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ClienteResource {
	//private final Logger log = LoggerFactory.getLogger(ClienteResource.class);
	
	@Autowired
	ClienteService clienteService;

	@PostMapping("/clientes")
	public ResponseEntity<?> saveCliente(@RequestBody ClienteDTO dto) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {

			response.put("Objeto", clienteService.add(dto));
			response.put("Mensaje", "Objeto creado correctamente");

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al guardar el objeto");
			response.put("Error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/clientes")
	public ResponseEntity<?> getClientes() {
		List<ClienteDTO> cliente = clienteService.getClientes();
		return new ResponseEntity<List<ClienteDTO>>(cliente, HttpStatus.OK);
	}
	
	@PutMapping("/clientes")
	public ResponseEntity<?> updateCliente(@RequestBody ClienteDTO dto) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			ClienteDTO cliente = clienteService.update(dto);
			response.put("Objeto", cliente);
			response.put("Mensaje", "Objeto modificado correctamente");

		} catch (NoSuchElementException e) {
			response.put("Mensaje", "No existe el Id del objeto");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al guardar el objeto");
			response.put("Error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
