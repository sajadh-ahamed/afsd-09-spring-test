package lk.acpt.car_sale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String model;
    private String color;
    private Double engineCap;
    private int noOfGears;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SparePart> spareParts;

    public Vehicle(Integer id, String name, String model, String color, Double engineCap, int noOfGears) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.color = color;
        this.engineCap = engineCap;
        this.noOfGears = noOfGears;
    }

}
