package by.astakhau.bonuslab.departments;

import by.astakhau.bonuslab.data.Departments;
import by.astakhau.bonuslab.data.Employee;
import by.astakhau.bonuslab.data.Truck;
import by.astakhau.bonuslab.service.EmployeeService;
import by.astakhau.bonuslab.service.TruckService;

import java.util.ArrayList;

public class LogisticsDepartment {
    ArrayList<Truck> trucksOnTheRoad;
    ArrayList<Truck> trucksInTheCity;

    ArrayList<Employee> employees;

    private final TruckService truckService;
    private final EmployeeService employeeService;

    public LogisticsDepartment(TruckService truckService, EmployeeService employeeService) {
        this.truckService = truckService;
        this.employeeService = employeeService;

        trucksOnTheRoad = new ArrayList<>();
        trucksInTheCity = new ArrayList<>(truckService.getAllTrucks());

        employees = new ArrayList<>(employeeService.getEmployeesByDepartment(Departments.LogisticsDepartment));
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeService.saveEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employeeService.deleteEmployee(employee.getId());
    }

    public void putTruckOnTheRoad(Truck truck) {
        trucksOnTheRoad.add(truck);

        trucksInTheCity.remove(truck);
        truckService.deleteTruckById(truck.getId());
    }

    public void getTruckFromTheRoad(Truck truck) {
        trucksInTheCity.add(truck);
        trucksOnTheRoad.remove(truck);

        truckService.saveTruck(truck);
    }
}
