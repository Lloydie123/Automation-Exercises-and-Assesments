import java.util.Scanner;

// Create a new Java class called ExceptionExercise in the default package.
public class ExceptionExercise {
    
    // Define a static method called getNumber that takes a Scanner object and a String message as parameters, and returns an int.
    public static int getNumber(Scanner scanner, String message) {
        int number = 0;
        boolean isValidInput = false;
        
        // use a while loop to validate the input. 
        while (!isValidInput) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
                isValidInput = true;
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter an integer.");
            }
        }
        
        return number;
    }
    // Define a static method called calculateAverage that takes three int parameters and returns a double.
    public static double calculateAverage(int num1, int num2, int num3) throws ArithmeticException, NullPointerException {
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            throw new ArithmeticException("Error: Division by zero not allowed.");
        }
        
        if (num1 < 0 || num2 < 0 || num3 < 0) {
            throw new NullPointerException("Error: One or more numbers are missing.");
        }
        
        return (num1 + num2 + num3) / 3.0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //  use a try-catch block to handle exceptions that may occur when getting the input or calculating the average.
        // prompt the user to enter an integer
        try {
            int num1 = getNumber(scanner, "Enter the first number: ");
            int num2 = getNumber(scanner, "Enter the second number: ");
            int num3 = getNumber(scanner, "Enter the third number: ");
            
            double average = calculateAverage(num1, num2, num3);
            System.out.println("The average of the three numbers is: " + average);
        // If the input is not a valid integer, the NumberFormatException catch block should execute
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter an integer.");
        // If any of the parameters are zero, it should throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        // If one or more of the numbers are missing, the NullPointerException catch block should execute
        } catch (NullPointerException e) {
            System.out.println("Error: One or more numbers are missing.");
        }
    }
}
