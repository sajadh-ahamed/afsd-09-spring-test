package lk.acpt.car_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private Integer id;
    private String name;
    private String model;
    private String color;
    private Double engineCap;
    private int noOfGears;
}
