package pe.com.megacentimetros.inventario.service;

import java.util.List;
import pe.com.megacentimetros.inventario.entity.AlmacenEntity;

public interface AlmacenService {

	List<AlmacenEntity> findAll();

	List<AlmacenEntity> findAllCustom();

	AlmacenEntity findById(Long id);

	AlmacenEntity add(AlmacenEntity obj);

	AlmacenEntity update(AlmacenEntity obj, Long id);

	AlmacenEntity delete(Long id);

	AlmacenEntity enable(Long id);
}
