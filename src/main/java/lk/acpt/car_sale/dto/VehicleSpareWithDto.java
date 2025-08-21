package lk.acpt.car_sale.dto;

import lk.acpt.car_sale.entity.SparePart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSpareWithDto {
    private String name;
    private String model;
    private String color;
    private Double engineCap;
    private int noOfGears;
    private List<SparePartDto> spareParts;
}
