package tech.blimop.grupo7.banco.service;

import java.time.LocalDate;
import java.util.List;
import tech.blimop.grupo7.banco.entity.Cliente;
import tech.blimop.grupo7.banco.entity.CuentaBancaria;
import tech.blimop.grupo7.banco.service.dto.request.CuentaBancariaDTO;
import tech.blimop.grupo7.banco.service.dto.request.MovimientoDTO;

public interface CuentaBancariaService {
	
	CuentaBancariaDTO add(Long id);
	
	CuentaBancariaDTO update(CuentaBancariaDTO cuentaDto);
	
	CuentaBancaria findByDni(String dni);
	
	List<CuentaBancariaDTO> getCuentasBancarias();
	
	
    void save(Cliente cliente);
    public List<CuentaBancariaDTO> cuentasDni(String dni);
	public List<MovimientoDTO> movimientosDni(String dni);
	public List<MovimientoDTO> movimientosEntreFechas(String numeroCuenta, LocalDate desde,LocalDate hasta);
	public MovimientoDTO deposito(MovimientoDTO moviemientoDto, Long cuenta_id);
	public MovimientoDTO extraccionCuenta(MovimientoDTO movimientoDto, Long cuenta_id);
	public CuentaBancariaDTO findByNumeroCuenta(String numeroCuenta);
}
