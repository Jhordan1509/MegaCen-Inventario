package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.client.CatalogoFeignClient;
import pe.com.megacentimetros.inventario.exception.ResourceNotFoundException;
import pe.com.megacentimetros.inventario.entity.ProductoEntity;
import pe.com.megacentimetros.inventario.repository.ProductoRepository;
import pe.com.megacentimetros.inventario.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public ProductoServiceImpl(ProductoRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<ProductoEntity> findAll() {
		List<ProductoEntity> lista = repositorio.findAll();
		for (ProductoEntity producto : lista) {
			producto.setCategoriaproducto(catalogoFeignClient.getCategoriaProducto(producto.getCodcat()));
			producto.setMarcaproducto(catalogoFeignClient.getMarcaProducto(producto.getCodmar()));
			producto.setTipoempaque(catalogoFeignClient.getTipoEmpaque(producto.getCodtipemp()));
		}
		return lista;
	}
	@Override
	public List<ProductoEntity> findAllCustom() {
		List<ProductoEntity> lista = repositorio.findAllCustom();
		for (ProductoEntity producto : lista) {
			producto.setCategoriaproducto(catalogoFeignClient.getCategoriaProducto(producto.getCodcat()));
			producto.setMarcaproducto(catalogoFeignClient.getMarcaProducto(producto.getCodmar()));
			producto.setTipoempaque(catalogoFeignClient.getTipoEmpaque(producto.getCodtipemp()));
		}
		return lista;
	}
	@Override
	public ProductoEntity findById(Long id) {
		ProductoEntity producto = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto con id " + id + " no existe"));
		producto.setCategoriaproducto(catalogoFeignClient.getCategoriaProducto(producto.getCodcat()));
		producto.setMarcaproducto(catalogoFeignClient.getMarcaProducto(producto.getCodmar()));
		producto.setTipoempaque(catalogoFeignClient.getTipoEmpaque(producto.getCodtipemp()));
		return producto;
	}
	@Override
	public ProductoEntity add(ProductoEntity obj) {
		obj.setEstado(true);
		if (obj.getPrecioCompra() == null) {
			obj.setPrecioCompra(java.math.BigDecimal.ZERO);
		}
		if (obj.getStockMinimo() == null) {
			obj.setStockMinimo(0);
		}
		return repositorio.save(obj);
	}
	@Override
	public ProductoEntity update(ProductoEntity obj, Long id) {
		ProductoEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objpro, "codigo");
		return repositorio.save(objpro);
	}
	@Override
	public ProductoEntity delete(Long id) {
		ProductoEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto con id " + id + " no existe"));
		objpro.setEstado(false);
		return repositorio.save(objpro);
	}
	@Override
	public ProductoEntity enable(Long id) {
		ProductoEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto con id " + id + " no existe"));
		objpro.setEstado(true);
		return repositorio.save(objpro);
	}
}
