import java.util.Scanner;

public class Main {

    String name;
    String surname;
    private String username;
    private String password;
    private String phoneNumber;

    // Registration method
    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        name = scanner.nextLine();

        System.out.print("Please enter your surname: ");
        surname = scanner.nextLine();

        while (true){
            System.out.print("Enter your username: ");
            this.username = scanner.nextLine();
            if (username.matches(".*_.*") && username.matches("[a-zA-Z0-9_]+") && username.length() <= 5) {
                System.out.println("\n****** SUCCESSFUL! ******");
                System.out.println("Username successfully captured.\n");
                break;
            } else {
                System.out.println("\n****** INVALID! ******");
                System.out.println("Username not correctly formatted, please ensure that your username contains an underscore (_) and is no more than five characters in length.\n");
            }
        }


        // Phone number input with validation
        while (true) {
            System.out.print("Enter your cell phone number (include international code, e.g. +27831234567): ");
            this.phoneNumber = scanner.nextLine();

            // Check basic structure with regex
            if (phoneNumber.matches("^\\+\\d{1,4}\\d{10}$")) {
                System.out.println("\n****** SUCCESSFUL! ******");
                System.out.println("Cell phone number successfully added.\n");
                break;
            } else {
                System.out.println("\n****** INVALID! ******");
                System.out.println("Cell phone number incorrectly formatted. Make sure it starts with an international code (e.g. +27) and is followed by exactly 10 digits.\n");
            }
        }


        while (true){
            System.out.print("Enter your password: ");
            this.password = scanner.nextLine();

            if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$")) {
                System.out.println("\n****** SUCCESSFUL! ******");
                System.out.println("Password successfully captured.\n");
                break;

            } else {
                System.out.println("****** INVALID! ******");
                System.out.println("Password not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }

        }


        System.out.println("\nRegistration complete!\n");
    }

    // Authentication method
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    // Display user details (excluding password)
    public void displayUserDetails() {
        System.out.println("********************************************");
        System.out.println("Welcome  " + this.name + " " + " " + this.surname + " it is great to see you again.");
        System.out.println("Username: " + this.username);
        System.out.println("Phone Number: " + this.phoneNumber);
        System.out.println("********************************************");
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main user = new Main();

        // Registration
        System.out.println("=== Registration ===");
        user.register();

        //Login
        System.out.println("****** Login Form ******");

        while (true) {
            System.out.print("Enter your username to login: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your password to login: ");
            String loginPassword = scanner.nextLine();

            // Authentication check
            if (user.authenticate(loginUsername, loginPassword)) {
                System.out.println("\nLogged in successfully");
                user.displayUserDetails();
                break; 
            } else {
                System.out.println("\n****** INVALID! ******");
                System.out.println("Login failed. Incorrect username or password.\n");
            }
        }

        scanner.close();
    }
}