// DSA: Exercise 4

package Week1_DataStructuresAndAlgorithms.Exercise4_EmployeeManagementSystem;

public class EmployeeManagementSystem {

    // Employee Class
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String toString() {
            return "[" + employeeId + "] " + name + " - " + position + " - " + salary;
        }
    }

    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    // Add employee
    public static void addEmployee(Employee emp) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = emp;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee array is full!");
        }
    }

    // Search by employeeId
    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public static void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public static boolean deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Manager", 75000));
        addEmployee(new Employee(2, "Bob", "Developer", 55000));
        addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        System.out.println("\nAll Employees:");
        displayEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        Employee found = searchEmployee(2);
        System.out.println(found != null ? found : "Not found.");

        System.out.println("\nDeleting Employee with ID 2:");
        deleteEmployee(2);

        System.out.println("\nUpdated Employee List:");
        displayEmployees();
    }
}

// Understanding Arrays:
// Arrays are fixed-size data structures that store elements of the same type.
// Arrays are best when: 1.Size is known and constant. 2. Fast index access is
// needed

// Add Employee: O(1) — Insert at end (constant time)
// Search Employee: O(n) — Linear search
// Traverse Employees: O(n) — Visit all
// Delete Employee: O(n) — Shift elements after deletion