package tech.blimop.grupo7.banco;


import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.blimop.grupo7.banco.entity.CuentaBancaria;
import tech.blimop.grupo7.banco.repository.CuentaBancariaRepository;

@SpringBootTest
public class Aa {
	
	@Autowired
	CuentaBancariaRepository clienteService;

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
		List<CuentaBancaria> cc = clienteService.cuentasDni("6533232");
		System.out.println(cc);
	}
		
}