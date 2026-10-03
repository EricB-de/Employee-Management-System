public class Employee {
    private String id;
    private String name;
    private String department;
    private double basicSalary;
    private double deductions;

    public Employee(String id, String name, String department, double basicSalary, double deductions) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }
        if (basicSalary < 0) {
            throw new IllegalArgumentException("Basic salary cannot be negative.");
        }
        if (deductions < 0) {
            throw new IllegalArgumentException("Deductions cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
        this.deductions = deductions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Employee name cannot be empty.");
        this.name = name;
    }

    public String getDepartment() { return department;}

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary < 0)
            throw new IllegalArgumentException("Basic salary cannot be negative.");
        this.basicSalary = basicSalary;
    }


    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        if (deductions < 0)
            throw new IllegalArgumentException("Deductions cannot be negative.");
        this.deductions = deductions;
    }

    public double calculateNetSalary() {
        double net = basicSalary - deductions;
        return Math.max(net, 0);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Dept: %s | Net: %.2f",
                id, name, department, calculateNetSalary());
    }
}
