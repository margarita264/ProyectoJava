package tech.blimop.grupo7.banco;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.blimop.grupo7.banco.entity.Movimiento;
import tech.blimop.grupo7.banco.repository.CuentaBancariaRepository;
import tech.blimop.grupo7.banco.repository.MovimientoRepository;

@SpringBootTest
public class EntreFechas {
	@Autowired
	CuentaBancariaRepository cuentaService;
	@Autowired
	MovimientoRepository movimientoService;

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
	void testfecha() {
		List<Movimiento> cc = movimientoService.movimientosEntreFechas("12341234",LocalDate.parse("2021-06-10"),LocalDate.parse("2021-06-11"));
		System.out.println(cc);
	}

}
