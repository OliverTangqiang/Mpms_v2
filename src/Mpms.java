import controller.UserController;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Mpms {

    public static void main(String[] args) {

        Mpms mpms = new Mpms();
        mpms.start();
    }

    private UserController userController;

    public Mpms()
    {
        userController = new UserController();

    }

    public void start()
    {
        System.out.print("Welcome! Please log in \n");
        boolean isSuccess = attemptLogin();
        System.out.println(isSuccess ? "Log in successfully!" : "Log in Failed...");
    }

    private boolean attemptLogin()
    {
        System.out.println("Please enter your email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        return userController.validateEmailAndPassword(email, password);
    }

}
