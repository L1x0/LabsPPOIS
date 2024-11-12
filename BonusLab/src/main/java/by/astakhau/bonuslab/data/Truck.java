package by.astakhau.bonuslab.data;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.LinkedList;

@Data
@Table("trucks")
public class Truck {
    private String color;
    private String model;
    private String engine;
    @Column("max_speed")
    private int maxSpeed;
    private int weight;
    @Column("max_weight")
    private int maxWeight;
    @Column("number_of_axes")
    private int numberOfAxes;
    LinkedList<String> route;

    public Truck() {
    }
}
