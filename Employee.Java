import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create an Employee object and set its values using user input
        Employee emp = createEmployee(scanner);
        
        // Display initial values of name, age, and salary using getter methods
        System.out.println("Initial values:");
        System.out.println(emp.getName() + " - " + emp.getAge() + " years old - $" + emp.getSalary());
        
        // Increase salary of the employee by a given percentage using raiseSalary() method
        emp.raiseSalary(10);
        
        // Display new salary and annual salary using getter methods
        System.out.println("\nNew salary and annual salary:");
        System.out.println(emp.getName() + " - $" + emp.getSalary() + " - $" + emp.getAnnualSalary());
        
        scanner.close();
    }
    
    public static Employee createEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline character
        
        System.out.print("Enter employee salary: $");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume the remaining newline character
        
        return new Employee(name, age, salary);
    }
    
    public static class Employee {
        private String name;
        private int age;
        private double salary;
        
        // Constructor to set initial values of instance variables
        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        
        // Getter methods for instance variables
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        public double getSalary() {
            return salary;
        }
        
        // Setter method for salary
        public void setSalary(double newSalary) {
            salary = newSalary;
        }
        
        // Method to calculate annual salary
        public double getAnnualSalary() {
            return salary * 12;
        }
        
        // Method to increase salary by a given percentage
        public void raiseSalary(double percentage) {
            salary = salary * (1 + percentage/100);
        }
    }
}
