package tech.blimop.grupo7.banco.service.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID= 1L;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty(value="id")
	private long id;
	
	@JsonProperty(value ="dni")
	private String dni;
	
	@JsonProperty (value="domicilio")
	private String domicilio;
	
	@JsonProperty (value="email")
	private String email;
	
	@JsonProperty (value ="nombre")
	private String nombre;
	
	@JsonProperty (value="telefono")
	private String telefono;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
