package pe.com.megacentimetros.inventario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-catalogo", url = "http://localhost:9091/pmega/api/")
public interface CatalogoFeignClient {
	@GetMapping("/categoriaproducto/{id}")
	Object getCategoriaProducto(@PathVariable("id") Long id);

	@GetMapping("/marcaproducto/{id}")
	Object getMarcaProducto(@PathVariable("id") Long id);

	@GetMapping("/tipoempaque/{id}")
	Object getTipoEmpaque(@PathVariable("id") Long id);
}
