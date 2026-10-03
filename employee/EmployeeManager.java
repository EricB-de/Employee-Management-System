import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        if (emp == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        if (findEmployeeById(emp.getId()) != null) {
            throw new IllegalArgumentException("Employee with ID " + emp.getId() + " already exists.");
        }
        employees.add(emp);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee findEmployeeById(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    public boolean updateEmployee(String id, String name, String department,
                                  double basicSalary, double deductions) {
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            emp.setName(name);
            emp.setDepartment(department);
            emp.setBasicSalary(basicSalary);
            emp.setDeductions(deductions);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(String id) {
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            return true;
        }
        return false;
    }

    public String generatePaymentReport() {
        StringBuilder report = new StringBuilder();
        double totalNetSalaries = 0;
        report.append("===== PAYMENT REPORT =====\n");

        for (Employee emp : employees) {
            double netSalary = emp.getBasicSalary() - emp.getDeductions();
            report.append(emp.toString()).append("\n");
            totalNetSalaries += netSalary;
        }

        report.append("--------------------------------\n");
        report.append("Total Employees: ").append(employees.size()).append("\n");
        report.append("Total Net Salaries: ").append(String.format("%.2f", totalNetSalaries)).append("\n");

        return report.toString();
    }


    public void addEmployeeFromConsole(Scanner scanner) {
        try {
            System.out.print("Employee ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Department: ");
            String department = scanner.nextLine().trim();

            double basicSalary = readDouble(scanner, "Basic Salary: ");
            double deductions = readDouble(scanner, "Deductions: ");

            addEmployee(new Employee(id, name, department, basicSalary, deductions));
            System.out.println("Employee added successfully.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    public void viewAllEmployeesFromConsole() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.\n");
            return;
        }
        System.out.println("----- All Employees -----");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println();
    }

    public void findEmployeeFromConsole(Scanner scanner) {
        System.out.print("Enter Employee ID to find: ");
        String id = scanner.nextLine().trim();
        Employee emp = findEmployeeById(id);
        if (emp == null) {
            System.out.println("No employee found with ID " + id + ".\n");
        } else {
            System.out.println(emp + "\n");
        }
    }

    public void updateEmployeeFromConsole(Scanner scanner) {
        try {
            System.out.print("Enter Employee ID to update: ");
            String id = scanner.nextLine().trim();

            if (findEmployeeById(id) == null) {
                System.out.println("No employee found with ID " + id + ".\n");
                return;
            }

            System.out.print("New Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("New Department: ");
            String department = scanner.nextLine().trim();

            double basicSalary = readDouble(scanner, "New Basic Salary: ");
            double deductions = readDouble(scanner, "New Deductions: ");

            boolean updated = updateEmployee(id, name, department, basicSalary,deductions);
            System.out.println(updated ? "Employee updated successfully.\n" : "Update failed.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    public void deleteEmployeeFromConsole(Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        String id = scanner.nextLine().trim();
        boolean deleted = deleteEmployee(id);
        System.out.println(deleted ? "Employee deleted successfully.\n" : "No employee found with ID " + id + ".\n");
    }

    public void generateReportFromConsole() {
        System.out.println(generatePaymentReport());
    }

    private double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
