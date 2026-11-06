package pe.com.megacentimetros.inventario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-persona", url = "http://localhost:9092/pmega/api/")
public interface PersonaFeignClient {
	@GetMapping("/sucursal/{id}")
	Object getSucursal(@PathVariable("id") Long id);
}
