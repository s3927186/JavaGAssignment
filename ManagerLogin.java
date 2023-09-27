package Port_manager;

import java.io.*;
import java.util.*;

public class ManagerLogin {
    private String Username;
    private String Password;

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        Username = scanner.nextLine();
        System.out.println("Password:");
        Password = scanner.nextLine();

        String line;
        String check = "no";
        try {
            while(check.equals("no")) {
                BufferedReader reader = new BufferedReader(new FileReader("Manager.csv"));
                while ((line = reader.readLine()) != null) {
                    String[] CurrentLine = line.split(",");
                    String user = (CurrentLine[1]);
                    String pass = (CurrentLine[2]);
                    if (getUsername().equals(user) && getPassword().equals(pass)) {
                        check = "yes";
                        break;
                    } else {
                        check = "no";
                    }
                }
                if (check.equals("no")) {
                    System.out.println("Username or Password is incorrect");
                    System.out.println("Username: ");
                    Username = scanner.nextLine();
                    System.out.println("Password:");
                    Password = scanner.nextLine();
                } else {
                    System.out.println("Welcome " + getUsername());
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

