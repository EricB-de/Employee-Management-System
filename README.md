# Employee Management System

## Description

The Employee Management System is a simple Java console-based application designed to help an organization manage employee information, process salary payments, and generate reports.

## Features

* Add new employees.
* View all registered employees.
* Search for employees using their ID.
* Update employee information.
* Delete employee records.
* Process employee salary payments.
* Calculate net salaries after deductions.
* Generate payment reports.
* Display total employees,  and total net salaries.

## Technologies Used

* **Programming Language:** Java
* **IDE:** IntelliJ IDEA
* **Concepts:** Object-Oriented Programming (OOP), Java Collections, Methods, Loops, and Exception Handling.

## Project Structure

```text
Employee-Management-System/
│
├── employee/
│   ├── Employee.java
│   ├── EmployeeManager.java
│   └── Main.java
│
└── README.md
```

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/EricB-de/Employee-Management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Locate the `Main.java` file inside the `employee` package.

4. Run the `Main.java` file.

5. Follow the menu instructions displayed in the console.

Alternatively, compile and run from the project root using:

```bash
javac -d out employee/*.java
java -cp out employee.Main
```

## Salary Calculation

The system calculates net salary using the following formula:

```text
Net Salary = Basic Salary - Deductions
```

## Testing

The application can be tested using:

* **Black-box testing:** To verify system functionality using different inputs and expected outputs.
* **White-box testing:** To verify internal methods, conditions, loops, and calculations.

## Author

**Eric Bikorimana**

## License

This project was developed for educational purposes.
