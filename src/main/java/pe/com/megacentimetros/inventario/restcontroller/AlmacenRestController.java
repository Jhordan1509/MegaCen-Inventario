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
import pe.com.megacentimetros.inventario.entity.AlmacenEntity;
import pe.com.megacentimetros.inventario.service.AlmacenService;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenRestController {

	@Autowired
	private AlmacenService servicio;

	@GetMapping
	public List<AlmacenEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<AlmacenEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public AlmacenEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public AlmacenEntity add(@RequestBody AlmacenEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public AlmacenEntity update(@RequestBody AlmacenEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public AlmacenEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public AlmacenEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
