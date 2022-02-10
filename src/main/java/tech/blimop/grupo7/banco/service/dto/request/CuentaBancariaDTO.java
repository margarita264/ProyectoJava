package tech.blimop.grupo7.banco.service.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CuentaBancariaDTO implements Serializable{
	private static final long serialVersionUID=1L;
	
	@JsonProperty(value="id")
	private long id;
	
	@JsonProperty (value ="fechaCreacion")
	private LocalDate fechaCreacion;

	@JsonProperty (value="numeroCuenta")
	private String numeroCuenta;
	
	@JsonProperty (value ="saldo")
	private float saldo;
	
	@JsonProperty(value = "cliente_id")
	private Long clienteId;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
