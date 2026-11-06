package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.client.PersonaFeignClient;
import pe.com.megacentimetros.inventario.exception.ResourceNotFoundException;
import pe.com.megacentimetros.inventario.entity.AlmacenEntity;
import pe.com.megacentimetros.inventario.repository.AlmacenRepository;
import pe.com.megacentimetros.inventario.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService {

	private AlmacenRepository repositorio;
	private PersonaFeignClient personaFeignClient;

	public AlmacenServiceImpl(AlmacenRepository repositorio,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<AlmacenEntity> findAll() {
		List<AlmacenEntity> lista = repositorio.findAll();
		for (AlmacenEntity almacen : lista) {
			almacen.setSucursal(personaFeignClient.getSucursal(almacen.getCodsuc()));
		}
		return lista;
	}
	@Override
	public List<AlmacenEntity> findAllCustom() {
		List<AlmacenEntity> lista = repositorio.findAllCustom();
		for (AlmacenEntity almacen : lista) {
			almacen.setSucursal(personaFeignClient.getSucursal(almacen.getCodsuc()));
		}
		return lista;
	}
	@Override
	public AlmacenEntity findById(Long id) {
		AlmacenEntity almacen = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Almacen con id " + id + " no existe"));
		almacen.setSucursal(personaFeignClient.getSucursal(almacen.getCodsuc()));
		return almacen;
	}
	@Override
	public AlmacenEntity add(AlmacenEntity obj) {
		obj.setEstado(true);
		if (obj.getSituacion() == null) {
			obj.setSituacion("OPERATIVO");
		}
		return repositorio.save(obj);
	}
	@Override
	public AlmacenEntity update(AlmacenEntity obj, Long id) {
		AlmacenEntity objalm = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Almacen con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objalm, "codigo");
		return repositorio.save(objalm);
	}
	@Override
	public AlmacenEntity delete(Long id) {
		AlmacenEntity objalm = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Almacen con id " + id + " no existe"));
		objalm.setEstado(false);
		return repositorio.save(objalm);
	}
	@Override
	public AlmacenEntity enable(Long id) {
		AlmacenEntity objalm = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Almacen con id " + id + " no existe"));
		objalm.setEstado(true);
		return repositorio.save(objalm);
	}
}
