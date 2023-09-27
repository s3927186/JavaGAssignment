import System_admin.*;
import Port_manager.*;
import System_admin.Add.*;
import System_admin.Remove.*;
import java.util.*;

public class Main {
    //Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            WelcomeScreen();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.println("Program Exited");
                case 1 -> ManagerLogin();
                case 2 -> runAdminLogin();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }
    //Welcome Screen
    public static void WelcomeScreen(){
        System.out.println("""
                COSC2081 GROUP ASSIGNMENT
                CONTAINER PORT MANAGEMENT SYSTEM
                Instructor: Mr. Minh Vu & Dr. Phong Ngo
                Group: Team 33
                s3927186, Nguyen Tan Thinh
                s3988418, Nguyen Trung Tin
                s3921846, Nguyen Dai Thanh

                Are you a Port Manager or Admin?
                1/Port Manager
                2/Admin
                0/Exit Program""");
    }
    //Manager side
    public static void ManagerChoices(){
        System.out.println("""
                What do you want to do?
                1/Add Containers
                2/Remove Containers
                0/Log out""");
    }

    public static void ManagerLogin() {
        AddContainers addContainers = new AddContainers();
        RemoveContainers removeContainers = new RemoveContainers();
        ManagerLogin ManagerLogin = new ManagerLogin();
        ManagerLogin.Login();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            ManagerChoices();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> addContainers.addContainers();
                case 2 -> removeContainers.removeContainers();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }

    //Admin side
    public static void AdminMenu(){
        System.out.println("""
                1/Add
                2/Remove
                0/Log out""");
    }
    public static void Add(){
        System.out.println("""
                1/Add Containers
                2/Add Managers
                3/Add Ports
                4/Add Vehicle
                0/back
                """);
    }

    public static void Remove(){
        System.out.println("""
                1/Remove Containers
                2/Remove Managers
                3/Remove Ports
                4/Remove Vehicle
                0/back
                """);
    }
    public static void runAdd(){
        AddContainers addContainers = new AddContainers();
        AddManagers addManagers = new AddManagers();
        AddPorts addPorts = new AddPorts();
        AddVehicle addVehicle = new AddVehicle();
        Scanner scanner =new Scanner(System.in);
        int input;
        do{
            Add();
            input =scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> addContainers.addContainers();
                case 2 -> addManagers.addManagers();
                case 3 -> addPorts.addPorts();
                case 4 -> addVehicle.addVehicles();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }

    public static void runRemove(){
        RemoveContainers removeContainers = new RemoveContainers();
        RemoveManagers removeManagers = new RemoveManagers();
        RemovePorts removePorts = new RemovePorts();
        RemoveVehicle removeVehicle = new RemoveVehicle();
        Scanner scanner =new Scanner(System.in);
        int input;
        do{
            Remove();
            input =scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> removeContainers.removeContainers();
                case 2 -> removeManagers.removeManager();
                case 3 -> removePorts.removePorts();
                case 4 -> removeVehicle.removeVehicles();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }

    public static void runAdminLogin() {
        AdminLogin AdminLogin = new AdminLogin();
        AdminLogin.Login();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            AdminMenu();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> runAdd();
                case 2 -> runRemove();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }
}
