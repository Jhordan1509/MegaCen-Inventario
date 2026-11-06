package pe.com.megacentimetros.inventario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.inventario.entity.AlmacenEntity;

public interface AlmacenRepository extends JpaRepository<AlmacenEntity, Long> {

	@Query("select d from AlmacenEntity d where d.estado = true")
	List<AlmacenEntity> findAllCustom();
}
