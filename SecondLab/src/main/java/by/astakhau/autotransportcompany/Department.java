package by.astakhau.autotransportcompany;

import java.util.ArrayList;

abstract class Department {
    private ArrayList<Employee> employees;
    private int countOfEmployees;
    private ArrayList<String> Tasks;

    public Department(ArrayList<Employee> employees) {
        this.employees = employees;
        this.countOfEmployees = employees.size();
        this.Tasks = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
        countOfEmployees = employees.size();
    }

    public int getCountOfEmployees() {
        return countOfEmployees;
    }

    public ArrayList<String> getTasks() {
        return Tasks;
    }

    public void addTasks(ArrayList<String> tasks) {
        Tasks.addAll(tasks);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        countOfEmployees++;
    }

    public void removeEmployee(int id) {

        if (!this.employees.isEmpty()) {
            for (int i = 0; i < employees.size(); i++) {
                if (this.employees.get(i).getEmployeeId() == id) {
                    this.employees.remove(i);
                    break;
                }
            }
            countOfEmployees--;
        }
    }

    public void addTask(String task) {
        this.Tasks.add(task);
    }

    public void removeTask(String task) {
        this.Tasks.remove(task);
    }

    @Override
    public String toString() {
        return "Department [employees=" + employees + ", countOfEmployees="
                + countOfEmployees + ", Tasks=" + Tasks + "]";
    }

}
