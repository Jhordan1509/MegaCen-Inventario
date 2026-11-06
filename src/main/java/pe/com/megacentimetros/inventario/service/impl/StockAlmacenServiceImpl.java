package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.exception.ResourceNotFoundException;
import pe.com.megacentimetros.inventario.entity.StockAlmacenEntity;
import pe.com.megacentimetros.inventario.repository.StockAlmacenRepository;
import pe.com.megacentimetros.inventario.service.StockAlmacenService;

@Service
public class StockAlmacenServiceImpl implements StockAlmacenService {

	private StockAlmacenRepository repositorio;

	public StockAlmacenServiceImpl(StockAlmacenRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<StockAlmacenEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<StockAlmacenEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public StockAlmacenEntity findById(Long id) {
		StockAlmacenEntity stockAlmacen = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockAlmacen con id " + id + " no existe"));
		return stockAlmacen;
	}
	@Override
	public StockAlmacenEntity add(StockAlmacenEntity obj) {
		obj.setEstado(true);
		if (obj.getCantidadDisponible() == null) {
			obj.setCantidadDisponible(0);
		}
		if (obj.getFechaActualizacion() == null) {
			obj.setFechaActualizacion(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public StockAlmacenEntity update(StockAlmacenEntity obj, Long id) {
		StockAlmacenEntity objsto = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockAlmacen con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objsto, "codigo");
		objsto.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsto);
	}
	@Override
	public StockAlmacenEntity delete(Long id) {
		StockAlmacenEntity objsto = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockAlmacen con id " + id + " no existe"));
		objsto.setEstado(false);
		objsto.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsto);
	}
	@Override
	public StockAlmacenEntity enable(Long id) {
		StockAlmacenEntity objsto = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockAlmacen con id " + id + " no existe"));
		objsto.setEstado(true);
		objsto.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsto);
	}
}
