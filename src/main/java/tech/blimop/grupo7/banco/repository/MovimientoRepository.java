package tech.blimop.grupo7.banco.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  tech.blimop.grupo7.banco.entity.*;

@Repository
public interface MovimientoRepository extends JpaRepository <Movimiento, Long>{
	
	//@Query(value="SELECT m FROM Movimiento m JOIN m.cuentaBancaria b WHERE m.fecha BETWEEN  :desde AND :hasta)")
	//List<Movimiento> movimientosEntreFechas(@Param("numeroCuenta") String numeroCuenta,@Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta);
	
	@Query(value="SELECT m FROM Movimiento m JOIN m.cuentaBancaria b WHERE b.numeroCuenta = :numeroCuenta AND (m.fecha BETWEEN  :desde AND :hasta)")
	List<Movimiento> movimientosEntreFechas(@Param("numeroCuenta") String numeroCuenta,
											@Param("desde") LocalDate desde, 
											@Param("hasta") LocalDate hasta);
	
	@Query(value="SELECT m FROM Movimiento m JOIN m.cuentaBancaria b WHERE b.numeroCuenta = :numeroCuenta")
	List<Movimiento> movimientosDni(@Param("numeroCuenta") String numeroCuenta);
	

}
