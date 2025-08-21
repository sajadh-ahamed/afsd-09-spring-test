package lk.acpt.car_sale.repo;

import lk.acpt.car_sale.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//this is vehiclerepo

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> getByNameAndModel(String name, String model);
}
