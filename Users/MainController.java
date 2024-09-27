package Users;

import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

import Attributes.DataBase;

public class MainController {
    private final Scanner scanner;
    private final DataBase database;

    public MainController(DataBase database) {
        this.database = database;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the System");
        while (true) {
            System.out.println("Please login to continue:");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = login(username, password);
            if (user != null) {
                if (user instanceof Admin) {
                    AdminController adminController = new AdminController((Admin) user);
                    adminController.run();
                }
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }

    private User login(String username, String password) {
        Vector<User> users = database.getUsers();
        for (User user : users) {
            if (user.getFirstName().equals(username) && user.getPasswordHash() == Objects.hash(password)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DataBase database = new DataBase();
        MainController mainController = new MainController(database);
        mainController.run();
    }
}
