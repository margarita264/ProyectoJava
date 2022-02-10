package tech.blimop.grupo7.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.blimop.grupo7.banco.entity.CuentaBancaria;
import tech.blimop.grupo7.banco.entity.Movimiento;

@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long>{
	
	List<Movimiento> findById(long id);
	
	/*@Query (value="SELECT cuenta_bancaria  from cuenta_bancaria INNER JOIN "
			+ "cliente on  cliente.cliente_id= cuenta_bancaria.cliente_id WHERE cliente.dni =: filtro")*/
	
	@Query(value="SELECT b FROM CuentaBancaria b JOIN b.cliente c WHERE c.dni = :dni")
	List<CuentaBancaria> cuentasDni(@Param("dni") String dni);
	
	List<CuentaBancaria>findAll();
	
    CuentaBancaria findByNumeroCuenta(String numeroCuenta);
	
	

}
