package tech.blimop.grupo7.banco;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.blimop.grupo7.banco.entity.Cliente;
import tech.blimop.grupo7.banco.entity.CuentaBancaria;
import tech.blimop.grupo7.banco.service.ClienteService;
import tech.blimop.grupo7.banco.service.CuentaBancariaService;

@SpringBootTest
public class TestsCase {
	@Autowired
	CuentaBancariaService cuentaService;

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
	void test() {
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cuentaBancaria.setNumeroCuenta("48758974589845");
		//cuentaBancaria.getFechaCreacion();
		cuentaBancaria.setSaldo(6);
		cuentaBancaria.setCliente(cliente);
		
		cuentaService.save(cliente);
		//cuentaService.addCuentaBancaria(cuentaBancaria);
		//cuentaService.add(cuentaBancaria);
		System.out.println(cuentaBancaria);
		
		//clienteService.addCuentaBancaria(cuentaBancaria);

		//List<CuentaBancaria> cuentasBancarias = clienteService.getCuentasBancarias("40456789");
			//for (CuentaBancaria cuenta : cuentasBancarias) {
				//System.out.println("Introducing cuentas prier cuenta => " + cuenta.getSaldo());
		//	}
		
	}
}
