package by.astakhau.bonuslab.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("clients")
public class Client extends People {

    @Id
    private long id;
    @Setter
    private long order_id;

    public Client(String name, int age) {
        super(name, age);
    }
}
