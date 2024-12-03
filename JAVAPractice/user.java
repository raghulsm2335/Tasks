package JAVAPractice;
import java.io.Console;
import java.io.IOException;

public class user {
    public static void main(String[] args) throws IOException {
        // Get the console object
        Console console = System.console();
        
        // Check if console is available (useful for IDEs, as some may not support console)
        if (console == null) {
            System.out.println("No console available");
            return;
        }

        // Asking for username
        String username = console.readLine("Enter username: ");
        
        // Asking for password with masking as '*'
        System.out.print("Enter password: ");
        char[] passwordArray = readPasswordWithMask();
        
        // Convert the password to a string
        String password = new String(passwordArray);
        
        // For demonstration purposes, let's print the entered credentials
        System.out.println("\nUsername: " + username);
        System.out.println("Password entered: " + password);  // In real applications, you would not print the password
        
        // Example: Verify login (you can replace this with actual authentication logic)
        if (username.equals("user") && password.equals("password123")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    // Method to mask the password with '*' while typing
    private static char[] readPasswordWithMask() throws IOException {
        char[] password = new char[100]; // maximum length for password
        int length = 0;
        
        while (true) {
            char ch = (char) System.in.read();  // Read a character from console
            
            if (ch == '\n' || ch == '\r') {  // End of input (Enter key)
                break;
            }
            
            if (ch == 127 || ch == '\b') {  // Handle backspace
                if (length > 0) {
                    length--;
                    System.out.print("\b \b");  // Erase the last character
                }
            } else {
                if (length < password.length) {
                    password[length++] = ch;
                    System.out.print('*');  // Print '*' to mask the character
                }
            }
        }

        return java.util.Arrays.copyOf(password, length);  // Return the masked password
    }
}
