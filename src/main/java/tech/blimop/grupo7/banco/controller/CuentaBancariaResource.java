package tech.blimop.grupo7.banco.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tech.blimop.grupo7.banco.service.CuentaBancariaService;
import tech.blimop.grupo7.banco.service.dto.request.CuentaBancariaDTO;
import tech.blimop.grupo7.banco.service.dto.request.MovimientoDTO;

@RestController
@RequestMapping("/api/cuenta")
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class CuentaBancariaResource {
	private final Logger log = LoggerFactory.getLogger(ClienteResource.class);

	@Autowired
	CuentaBancariaService cuentaService;

	@PostMapping("/cuentas/{id}")
	public ResponseEntity<?> saveCuenta(@PathVariable Long id) {

		log.debug("API REST agregando cuenta bancaria al Cliente con id  [" + id + "]");
		Map<String, Object> response = new HashMap<String, Object>();
		try {

			response.put("Objeto", cuentaService.add(id));
			response.put("Mensaje", "Objeto creado correctamente");

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al guardar el objeto");
			response.put("Error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/cuentas")
	public ResponseEntity<?> getCuentas() {
		List<CuentaBancariaDTO> cuenta = cuentaService.getCuentasBancarias();
		return new ResponseEntity<List<CuentaBancariaDTO>>(cuenta, HttpStatus.OK);
	}

	@PutMapping("/cuentas")
	public ResponseEntity<?> updateCuenta(@RequestBody CuentaBancariaDTO dto) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			CuentaBancariaDTO cuenta = cuentaService.update(dto);
			response.put("Objeto", cuenta);
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

	@PostMapping("/deposito/{cuenta_id}")
	public ResponseEntity<?> depositoCuenta(@RequestBody MovimientoDTO movimientoDto, @PathVariable Long cuenta_id) {

		log.debug("API REST agregando nuevo movide de la cuenta id  [" + cuenta_id + "]");
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			response.put("Objeto", cuentaService.deposito(movimientoDto, cuenta_id));
			response.put("Mensaje", "Objeto creado correctamente");
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al guardar el objeto");
			response.put("Error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PostMapping("/extraccion/{cuenta_id}")
	public ResponseEntity<?> extraccionCuenta(@RequestBody MovimientoDTO movimientoDto, @PathVariable Long cuenta_id) {

		log.debug("API REST agregando nuevo movide de la cuenta id  [" + cuenta_id + "]");
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			response.put("Objeto", cuentaService.extraccionCuenta(movimientoDto, cuenta_id));
			response.put("Mensaje", "Extraccion exitosa");
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al guardar el objeto");
			response.put("Error", e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/cuenta/cuentabancarias/{dni}")
	public List<CuentaBancariaDTO> cuentasDni(@PathVariable String dni) {

		log.debug("API REST buscando cuentas por dni  [" + dni + "]");

		return cuentaService.cuentasDni(dni);

	}

	@GetMapping("/cuenta/movimientos/{dni}")
	public List<MovimientoDTO> movimientosDni(@PathVariable String dni) {

		log.debug("API REST buscando movimientos por dni  [" + dni + "]");

		return cuentaService.movimientosDni(dni);

	}

	@GetMapping("/cuenta/movimientofecha/{numeroCuenta}/{fechaIni}/{fechaFin}")
	public List<MovimientoDTO> movimientosEntreFechas(@PathVariable String cuenta, @PathVariable LocalDate Finicio,
			@PathVariable LocalDate Ffinal) {

		log.debug("API REST buscando movimientos de una cuenta por fecha  [" + cuenta + Finicio+ Ffinal+ "]");

		return cuentaService.movimientosEntreFechas(cuenta, Finicio, Ffinal);
	}

}
