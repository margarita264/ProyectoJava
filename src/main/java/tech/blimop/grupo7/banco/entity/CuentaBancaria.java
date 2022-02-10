package tech.blimop.grupo7.banco.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Column(name = "numeroCuenta")
	private String numeroCuenta;

	@Column(name = "fechaCreacion")
	//@Temporal(TemporalType.DATE)
	private LocalDate fechaCreacion;

	@Column(name = "saldo")
	private float saldo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cuentaBancaria")
	private List<Movimiento> movimientos;
	
	public CuentaBancaria() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void addMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
		movimiento.setCuentaBancaria(this);
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", cliente=" + cliente + ", numeroCuenta=" + numeroCuenta
				+ ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", movimientos=" + movimientos + "]";
	}

	
	
	
}
