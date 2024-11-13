package by.astakhau.bonuslab.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Table(name = "employees")
public class Employee {
    @Id
    public Integer id;

    @Column(value = "name")
    public String name;

    @Column(value = "age")
    public Integer age;

    @Column(value = "salary")
    public BigDecimal salary;

    @Column(value = "experience")
    public Integer experience;

    private Departments department;
}