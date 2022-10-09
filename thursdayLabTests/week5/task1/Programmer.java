// Remove public in hackerrank submission
public class Programmer extends Employee {
    private final double bonus;
    private final String specialization;

    public Programmer(String name, double salary, double bonus, String specialization) {
        super(name, salary);
        this.bonus = bonus;
        this.specialization = specialization;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "; Programmer for " + specialization;
    }
}
