public class Employee {
    private final double salary;
    private final String name;

    public Employee(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + getSalary();
    }

    public double getSalary() {
        return salary;
    }
}
