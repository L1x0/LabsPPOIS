package by.astakhau.bonuslab.departments;

import by.astakhau.bonuslab.data.Client;
import by.astakhau.bonuslab.data.Departments;
import by.astakhau.bonuslab.data.Employee;
import by.astakhau.bonuslab.data.Order;
import by.astakhau.bonuslab.service.ClientService;
import by.astakhau.bonuslab.service.EmployeeService;
import by.astakhau.bonuslab.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MarketingDepartment {
    EmployeeService employeeService;
    ArrayList<Employee> employees;

    ClientService clientService;
    ArrayList<Client> clients;

    OrderService orderService;
    ArrayList<Order> orders;

    public MarketingDepartment(EmployeeService employeeService, ClientService clientService, OrderService orderService) {
        this.employeeService = employeeService;
        this.employees = new ArrayList<>(employeeService.getEmployeesByDepartment(Departments.MarketingDepartment));

        this.clientService = clientService;
        this.clients = new ArrayList<>(clientService.getAllClients());

        this.orderService = orderService;
        this.orders = new ArrayList<>(orderService.getAllOrders());
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeService.saveEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employeeService.deleteEmployee(employee.getId());
    }

    public void addOrder(Order order, Client client) {
        orders.add(order);
        orderService.saveOrder(order);

        client.setOrder_id(order.getId());
        clients.add(client);
        clientService.saveClient(client);
    }

    public void deleteOrder(Order order, Client client) {
        orders.remove(order);
        clients.remove(client);

        orderService.deleteOrderById(order.getId());
        clientService.deleteByOrderId(order.getId());
    }
}
