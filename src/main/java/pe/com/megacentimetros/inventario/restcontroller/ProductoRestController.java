package pe.com.megacentimetros.inventario.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.inventario.entity.ProductoEntity;
import pe.com.megacentimetros.inventario.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService servicio;

	@GetMapping
	public List<ProductoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<ProductoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public ProductoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public ProductoEntity add(@RequestBody ProductoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public ProductoEntity update(@RequestBody ProductoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public ProductoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public ProductoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
