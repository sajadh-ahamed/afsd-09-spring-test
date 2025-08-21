package lk.acpt.car_sale;

import lk.acpt.car_sale.entity.Vehicle;
import lk.acpt.car_sale.repo.VehicleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSaleApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(VehicleRepo vehicleRepo) {
		return args -> {
			vehicleRepo.saveAll(List.of(
					new Vehicle(null, "Toyota", "Corolla", "White", 1.8, 6),
					new Vehicle(null, "Toyota", "Camry", "Black", 2.0, 6),
					new Vehicle(null, "Honda", "Civic", "Red", 1.5, 5),
					new Vehicle(null, "Honda", "Accord", "Blue", 2.0, 6)
			));
		};
	}
}
