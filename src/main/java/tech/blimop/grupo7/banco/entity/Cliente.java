package tech.blimop.grupo7.banco.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dni")
	private String dni;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "domicilio")
	private String domicilio;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
	private List<CuentaBancaria> cuentasBancarias;

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public List<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", telefono=" + telefono + ", nombre=" + nombre + ", email="
				+ email + ", domicilio=" + domicilio + ", cuentasBancarias=" + cuentasBancarias + "]";
	}
	
	
}