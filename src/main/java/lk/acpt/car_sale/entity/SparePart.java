package lk.acpt.car_sale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SparePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")  // foreign key in SparePart table
    private Vehicle vehicle;
}
