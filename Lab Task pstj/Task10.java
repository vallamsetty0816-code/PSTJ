import java.util.*;

class InvalidLoginException extends Exception {
    InvalidLoginException(String message) {
        super(message);
    }
}

class LoginSystem {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    // Login validation
    boolean login(String username, String password)
            throws InvalidLoginException {

        // Boundary value testing
        if (username.length() < 3 || username.length() > 20) {
            throw new InvalidLoginException("Invalid username length");
        }

        if (password.length() < 6 || password.length() > 20) {
            throw new InvalidLoginException("Invalid password length");
        }

        // Edge case validation
        if (username.contains(" ") || password.contains(" ")) {
            throw new InvalidLoginException("Spaces are not allowed");
        }

        // Authentication
        return username.equals(VALID_USERNAME)
                && password.equals(VALID_PASSWORD);
    }
}

public class Task10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LoginSystem system = new LoginSystem();

        for (int i = 0; i < n; i++) {

            String username = sc.next();
            String password = sc.next();

            try {

                boolean result = system.login(username, password);

                if (result) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILURE");
                }

            } catch (InvalidLoginException e) {

                System.out.println("FAILURE");
            }
        }

        sc.close();
    }
}
