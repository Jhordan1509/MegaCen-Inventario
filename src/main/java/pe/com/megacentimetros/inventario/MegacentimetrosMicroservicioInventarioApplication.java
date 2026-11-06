package pe.com.megacentimetros.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MegacentimetrosMicroservicioInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegacentimetrosMicroservicioInventarioApplication.class, args);
	}

}
