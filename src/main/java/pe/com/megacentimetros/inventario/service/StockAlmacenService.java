package pe.com.megacentimetros.inventario.service;

import java.util.List;
import pe.com.megacentimetros.inventario.entity.StockAlmacenEntity;

public interface StockAlmacenService {

	List<StockAlmacenEntity> findAll();

	List<StockAlmacenEntity> findAllCustom();

	StockAlmacenEntity findById(Long id);

	StockAlmacenEntity add(StockAlmacenEntity obj);

	StockAlmacenEntity update(StockAlmacenEntity obj, Long id);

	StockAlmacenEntity delete(Long id);

	StockAlmacenEntity enable(Long id);
}
