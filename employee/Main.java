import java.util.Scanner;

public class Main {
    private static final EmployeeManager manager = new EmployeeManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 7) {
            printMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        manager.addEmployeeFromConsole(scanner);
                        break;
                    case 2:
                        manager.viewAllEmployeesFromConsole();
                        break;
                    case 3:
                        manager.findEmployeeFromConsole(scanner);
                        break;
                    case 4:
                        manager.updateEmployeeFromConsole(scanner);
                        break;
                    case 5:
                        manager.deleteEmployeeFromConsole(scanner);
                        break;
                    case 6:
                        manager.generateReportFromConsole();
                        break;
                    case 7:
                        System.out.println("Thank you for using the system!");
                        System.out.println("Application closed.");
                        break;
                    default:
                        System.out.println("Invalid option! Please choose 1-7.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {

        System.out.println("===== Employee Management System =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Find Employee by ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Generate Payment Report");
        System.out.println("7. Exit");

        System.out.print("Choose an option: ");
    }
}