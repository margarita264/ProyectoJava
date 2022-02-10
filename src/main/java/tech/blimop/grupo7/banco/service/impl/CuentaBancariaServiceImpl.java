package tech.blimop.grupo7.banco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import tech.blimop.grupo7.banco.entity.Cliente;
import tech.blimop.grupo7.banco.entity.CuentaBancaria;
import tech.blimop.grupo7.banco.entity.Movimiento;
import tech.blimop.grupo7.banco.repository.ClienteRepository;
import tech.blimop.grupo7.banco.repository.CuentaBancariaRepository;
import tech.blimop.grupo7.banco.repository.MovimientoRepository;
import tech.blimop.grupo7.banco.service.CuentaBancariaService;
import tech.blimop.grupo7.banco.service.dto.request.CuentaBancariaDTO;
import tech.blimop.grupo7.banco.service.dto.request.MovimientoDTO;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	@Autowired
    private ClienteRepository clienteRepository;
	@Autowired
	private CuentaBancariaRepository cuentaRepository;
	@Autowired
	private MovimientoRepository movimientoRepository;
	

	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuentaBancariaDTO add(Long id) {
	
			CuentaBancaria nuevaCuenta = new CuentaBancaria();
			Optional <Cliente> cliente =clienteRepository.findById(id);
			nuevaCuenta.setCliente(cliente.get());
			nuevaCuenta.setSaldo(0);
			nuevaCuenta.setFechaCreacion(LocalDate.now());
			
			Random r= new Random();
			long numero= r.nextLong(900000000)+100000000;
			nuevaCuenta.setNumeroCuenta(Long.toString(numero));
			
			nuevaCuenta = cuentaRepository.save(nuevaCuenta);
			
			CuentaBancariaDTO dto= new CuentaBancariaDTO();
			dto.setId(nuevaCuenta.getId());
			dto.setClienteId(id);
			dto.setFechaCreacion(nuevaCuenta.getFechaCreacion());
			dto.setNumeroCuenta(nuevaCuenta.getNumeroCuenta());
			nuevaCuenta.setSaldo(nuevaCuenta.getSaldo());
			
			return dto;
	}

	@Override
	public CuentaBancariaDTO update(CuentaBancariaDTO cuentaDto) {
		CuentaBancaria entity = new CuentaBancaria();
		
		entity.setFechaCreacion(cuentaDto.getFechaCreacion());
		entity.setSaldo(cuentaDto.getSaldo());

		cuentaRepository.save(entity);
		return cuentaDto;
	}

	@Override
	public CuentaBancaria findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaBancariaDTO> getCuentasBancarias() {
		List<CuentaBancaria> cuentas = cuentaRepository.findAll();
		List<CuentaBancariaDTO> dtos= new ArrayList<CuentaBancariaDTO>();
		
		for (CuentaBancaria c: cuentas)
		{
			CuentaBancariaDTO dto= new CuentaBancariaDTO();
			
			dto.setId(c.getId());
			//dto.setClienteId(c.getClienteId());
			dto.setFechaCreacion(c.getFechaCreacion());
			dto.setNumeroCuenta(c.getNumeroCuenta());
			dto.setSaldo(c.getSaldo());
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	@Override
	public MovimientoDTO deposito(MovimientoDTO movimientoDto, Long cuenta_id) {
	
		Optional<CuentaBancaria> cuenta = cuentaRepository.findById(cuenta_id);
		
		cuenta.get().setSaldo(cuenta.get().getSaldo() + movimientoDto.getImporte());
		cuentaRepository.save(cuenta.get());
		
		Movimiento movimiento = new Movimiento();
			
		movimiento.setImporte(movimientoDto.getImporte());
		movimiento.setFecha(LocalDate.now());
		movimiento.setCuentaBancaria(cuenta.get());

		movimientoRepository.save(movimiento);
		
		movimientoDto.setId(movimiento.getId());
		movimientoDto.setFecha(movimiento.getFecha());
		movimientoDto.setCuenta_id(cuenta.get().getId());
		movimientoDto.setTipoDeMovimiento("Deposito");
		
		return movimientoDto;
		
	}

	

	@Override
	public MovimientoDTO extraccionCuenta(MovimientoDTO movimientoDto, Long cuenta_id) {
		
		Optional<CuentaBancaria> cuenta = cuentaRepository.findById(cuenta_id);
		
		if (cuenta.get().getSaldo()>= movimientoDto.getImporte()) {
			cuenta.get().setSaldo(cuenta.get().getSaldo() - movimientoDto.getImporte());
			cuentaRepository.save(cuenta.get());
			
			Movimiento movimiento = new Movimiento();
				
			movimiento.setImporte(movimientoDto.getImporte());
			movimiento.setFecha(LocalDate.now());
			movimiento.setCuentaBancaria(cuenta.get());

			movimientoRepository.save(movimiento);
			
			movimientoDto.setId(movimiento.getId());
			movimientoDto.setFecha(movimiento.getFecha());
			movimientoDto.setCuenta_id(cuenta.get().getId());
			movimientoDto.setTipoDeMovimiento("Extraccion");
			
			return movimientoDto;
		} else {
			return null;
		}
	}

	@Override
	public List<CuentaBancariaDTO> cuentasDni(String dni) {
		
			// TODO Auto-generated method stub
			List<CuentaBancaria> lista = cuentaRepository.cuentasDni(dni);
			Cliente cliente = clienteRepository.findByDni(dni);
			List<CuentaBancariaDTO> cuentasDto = new ArrayList<CuentaBancariaDTO>();
			
			CuentaBancariaDTO cuentaDto; 
			for (CuentaBancaria item : lista) {
				cuentaDto = new CuentaBancariaDTO();
				cuentaDto.setFechaCreacion(item.getFechaCreacion());
				cuentaDto.setId(item.getId());
				cuentaDto.setNumeroCuenta(item.getNumeroCuenta());
				cuentaDto.setSaldo(item.getSaldo());
				//cuentaDto.setNombreCliente(cliente.getNombre());
				cuentaDto.setClienteId(cliente.getId());
				
				cuentasDto.add(cuentaDto);
				cuentaDto = null;
			}
			return cuentasDto;
		
	}
	
	@Override
	public List<MovimientoDTO> movimientosDni(String dni) {
		// TODO Auto-generated method stub
		//UNA LISTA DE DTOS
		List<CuentaBancariaDTO> lista =cuentasDni(dni);
		List<MovimientoDTO> movimientosCliente = new ArrayList<MovimientoDTO>();
		
		for (CuentaBancariaDTO cuenta : lista) 
        {
			//TRAE MOVIMIENTOS POR NUMERO DE CUENTA
			List<Movimiento> listaMovimiento = movimientoRepository.movimientosDni(cuenta.getNumeroCuenta());
			//List<MovimientosDTO> listamoviDTO = new ArrayList<MovimientosDTO>();
			
			for (Movimiento movimiento : listaMovimiento) 
	        {
				MovimientoDTO movimientoDto = new MovimientoDTO();
				movimientoDto.setFecha(movimiento.getFecha());
				movimientoDto.setImporte(movimiento.getImporte());
				movimientoDto.setCuenta_id(movimiento.getCuentaBancaria().getId());
				
				movimientosCliente.add(movimientoDto);
				movimientoDto = null;
	        }
			listaMovimiento = null;
        } 
		return movimientosCliente;
	}

	
	
	
	@Override
	public CuentaBancariaDTO findByNumeroCuenta(String numeroCuenta) {
		// TODO Auto-generated method stub
					CuentaBancaria cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
					
					//CuentaBancariaDTO cuentasDto = new CuentaBancariaDTO();
					
					CuentaBancariaDTO cuentaDto; 
					
						cuentaDto = new CuentaBancariaDTO();
						cuentaDto.setFechaCreacion(cuenta.getFechaCreacion());
						cuentaDto.setId(cuenta.getId());
						cuentaDto.setNumeroCuenta(cuenta.getNumeroCuenta());
						cuentaDto.setSaldo(cuenta.getSaldo());
						//cuentaDto.setNombreCliente(cliente.getNombre());
						//cuentaDto.setClienteId(cliente.getId());
						
						//cuentasDto.add(cuentaDto);
						
					return cuentaDto;
	}

	@Override
	public List<MovimientoDTO> movimientosEntreFechas(String numeroCuenta, LocalDate desde, LocalDate hasta) {
		List<Movimiento> movimientos =movimientoRepository.movimientosEntreFechas(numeroCuenta,desde,hasta);
		List<MovimientoDTO> movimientosFecha = new ArrayList<MovimientoDTO>();//vacio
		
		MovimientoDTO movimientoDto; 
		for (Movimiento item : movimientos) {
			movimientoDto = new MovimientoDTO();
			movimientoDto.setImporte(item.getImporte());
			movimientoDto.setTipoDeMovimiento(item.getTipoMovimiento());
			movimientoDto.setFecha(item.getFecha());
			movimientoDto.setCuenta_id(item.getCuentaBancaria().getId());
			
			movimientosFecha.add(movimientoDto);
			movimientoDto = null;
		}
		return movimientosFecha;
	}
	

}
