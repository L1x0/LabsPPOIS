package by.astakhau.bonuslab.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("clients")
public class Client extends People {

    @Id
    private long id;
    private int order_id;
    private Departments department;

    public Client(String name, int age) {
        super(name, age);
    }
}
