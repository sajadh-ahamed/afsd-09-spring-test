package lk.acpt.car_sale.controller;

import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleSpareWithDto;
import lk.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public VehicleDto addVehicle(@RequestBody VehicleDto dto) {
        return vehicleService.saveVehicle(dto);
    }

    @GetMapping
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/{id}")
    public VehicleDto getVehicle(@PathVariable int id) {
        return vehicleService.getVehicle(id);
    }

    @PutMapping
    public VehicleDto updateVehicle(@RequestBody VehicleDto dto) {
        return vehicleService.updateVehicle(dto);
    }

    @DeleteMapping("/{id}")
    public VehicleDto deleteVehicle(@PathVariable int id) {
        return vehicleService.deleteVehicle(id);
    }

    @GetMapping("/name/{name}/model/{model}")
    public List<VehicleDto> getByNameAndModel(@PathVariable String name, @PathVariable String model) {
        return vehicleService.getByNameAndModel(name, model);
    }

    @PostMapping("/spare")
    public ResponseEntity<VehicleWithSparePartsDTO> saveVehicleWithSpareParts(@RequestBody VehicleWithSparePartsDTO vehicleWithSparePartsDTO){
        VehicleWithSparePartsDTO vehicleWithSparePartsDTO1 = vehicleService.saveVehicleWithSpareParts(vehicleWithSparePartsDTO);
        return new ResponseEntity<>(vehicleWithSparePartsDTO1, HttpStatus.CREATED);
    }



}
