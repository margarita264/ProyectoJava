package tech.blimop.grupo7.banco.service.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovimientoDTO {

	//private static final long serialVersionUID=1L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "importe")
	private float importe;

	@JsonProperty(value = "fecha")
	private LocalDate fecha;

	@JsonProperty(value = "TipoDeMovimiento")
	private String TipoDeMovimiento;

	@JsonProperty(value = "cuenta_bancaria_id")
	private Long cuenta_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipoDeMovimiento() {
		return TipoDeMovimiento;
	}

	public void setTipoDeMovimiento(String tipoDeMovimiento) {
		TipoDeMovimiento = tipoDeMovimiento;
	}

	public Long getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(Long cuenta_id) {
		this.cuenta_id = cuenta_id;
	}

}
