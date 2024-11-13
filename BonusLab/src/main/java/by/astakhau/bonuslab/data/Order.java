package by.astakhau.bonuslab.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("orders")
public class Order {
    @Id
    private long id;
    private int customerId;
    private int productId;
    private String country;

    public Order(String country, int productId, int customerId, int id) {
        this.country = country;
        this.productId = productId;
        this.customerId = customerId;
        this.id = id;
    }

}