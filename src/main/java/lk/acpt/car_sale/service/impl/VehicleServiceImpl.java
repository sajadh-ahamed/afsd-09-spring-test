package lk.acpt.car_sale.service.impl;

import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.entity.Vehicle;
import lk.acpt.car_sale.repo.VehicleRepo;
import lk.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

     VehicleRepo vehicleRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle(
                vehicleDto.getId(),
                vehicleDto.getName(),
                vehicleDto.getModel(),
                vehicleDto.getColor(),
                vehicleDto.getEngineCap(),
                vehicleDto.getNoOfGears()
        );
        Vehicle saved = vehicleRepo.save(vehicle);
        return new VehicleDto(
                saved.getId(),
                saved.getName(),
                saved.getModel(),
                saved.getColor(),
                saved.getEngineCap(),
                saved.getNoOfGears()
        );
    }

    @Override
    public List<VehicleDto> getVehicles() {
        return vehicleRepo.findAll().stream()
                .map(v -> new VehicleDto(
                        v.getId(),
                        v.getName(),
                        v.getModel(),
                        v.getColor(),
                        v.getEngineCap(),
                        v.getNoOfGears()
                ))
                .toList();
    }

    @Override
    public VehicleDto getVehicle(int id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if(vehicle.isEmpty()) return null;
        Vehicle v = vehicle.get();
        return new VehicleDto(v.getId(), v.getName(), v.getModel(), v.getColor(), v.getEngineCap(), v.getNoOfGears());
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Vehicle existing = vehicleRepo.findById(vehicleDto.getId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        existing.setName(vehicleDto.getName());
        existing.setModel(vehicleDto.getModel());
        existing.setColor(vehicleDto.getColor());
        existing.setEngineCap(vehicleDto.getEngineCap());
        existing.setNoOfGears(vehicleDto.getNoOfGears());

        Vehicle updated = vehicleRepo.save(existing);

        return new VehicleDto(
                updated.getId(),
                updated.getName(),
                updated.getModel(),
                updated.getColor(),
                updated.getEngineCap(),
                updated.getNoOfGears()
        );
    }

    @Override
    public VehicleDto deleteVehicle(int id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if(vehicle.isEmpty()) return null;
        Vehicle v = vehicle.get();
        vehicleRepo.delete(v);
        return new VehicleDto(v.getId(), v.getName(), v.getModel(), v.getColor(), v.getEngineCap(), v.getNoOfGears());
    }

    @Override
    public List<VehicleDto> getByNameAndModel(String name, String model) {
        List<Vehicle> vehicles = vehicleRepo.getByNameAndModel(name, model);
        List<VehicleDto> dtos = new ArrayList<>();

        for (Vehicle v : vehicles) {
            VehicleDto dto = new VehicleDto(
                    v.getId(),
                    v.getName(),
                    v.getModel(),
                    v.getColor(),
                    v.getEngineCap(),
                    v.getNoOfGears()
            );
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public VehicleWithSparePartsDTO saveVehicleWithSpareParts(VehicleWithSparePartsDTO vwsDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vwsDto.getBrand());
        vehicle.setModel(vwsDto.getModel());
        vehicle.setEngineCapacity(vwsDto.getEngineCapacity());
        vehicle.setNoOfGears(vwsDto.getNoOfGears());

        ArrayList<SpareParts> list = new ArrayList<>();
        for(SparePartsDTO sparePartsDTO : vwsDto.getSparePartsDTOList()){
            list.add(new SpareParts(sparePartsDTO.getName(),sparePartsDTO.getPrice(),vehicle));
        }

        vehicle.setSpareParts(list);
        Vehicle saved = vehicleRepo.save(vehicle);

        return vwsDto;
//        return new VehicleWithSparePartsDTO(saved.getBrand(),saved.getModel(),saved.getEngineCapacity(),saved.getNoOfGears(),saved.getSpareParts());
    }




}
