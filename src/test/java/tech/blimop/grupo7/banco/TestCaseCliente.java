package tech.blimop.grupo7.banco;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.blimop.grupo7.banco.entity.Cliente;
import tech.blimop.grupo7.banco.entity.CuentaBancaria;
import tech.blimop.grupo7.banco.service.ClienteService;

@SpringBootTest
public class TestCaseCliente {
	
	@Autowired
	ClienteService clienteService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
		
	@BeforeEach
	void setUp() throws Exception {		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAgregarCliente() {
		
		Cliente cliente = new Cliente();
		
		
		//cliente.setId(1L);
		cliente.setDni("232323");
		cliente.setDomicilio("domicilio1");
		cliente.setEmail("cliente@mail.com");
		cliente.setNombre("ClienteNombre");
		cliente.setTelefono("23232323");
		
		System.out.println(cliente.toString());
	
		//clienteService.add(cliente);
		
		Cliente clienteSearch = clienteService.findById(cliente.getId());
		
		assertNotNull(clienteSearch);
		
		clienteService.deleteCliente(clienteSearch.getId());
		
	}
		
}