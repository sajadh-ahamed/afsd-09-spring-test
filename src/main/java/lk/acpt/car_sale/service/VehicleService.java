package lk.acpt.car_sale.service;

import lk.acpt.car_sale.dto.VehicleDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VehicleService {
    VehicleDto saveVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getVehicles();
    VehicleDto getVehicle(int id);
    VehicleDto updateVehicle(VehicleDto vehicleDto);
    VehicleDto deleteVehicle(int id);

    List<VehicleDto> getByNameAndModel(String name, String model);

}
