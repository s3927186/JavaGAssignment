package System_admin.Add;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AddVehicle {
    //generated Vehicles ID
    private String ID;

    public String getID() {
        return ID;
    }

    public void VehiclesID() {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Vehicles.csv"));
            while((line = reader.readLine()) != null) {
                String[] CurrentLine = line.split(",");
                String[] LeadId = CurrentLine[0].split("");
                int i = Integer.parseInt(LeadId[3]);
                i += 1;
                String s = Integer.toString(i);
                LeadId[3] = s;
                ID = Arrays.toString(LeadId).replaceAll("[^a-zA-Z\\d]","");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addVehicles() {
        VehiclesID();
        //Input items information
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String Name = scanner.nextLine();
        System.out.println("Current fuel:");
        String Fuel = scanner.nextLine();
        System.out.println("Carrying capacity: ");
        String CarryingCapacity= scanner.nextLine();
        System.out.println("Fuel capacity: ");
        String FuelCapacity = scanner.nextLine();
        System.out.println("Type: ");
        String Type = scanner.nextLine();
        System.out.println("Current port: ");
        String CurrentPort = scanner.nextLine();
        //append new information to csv file
        File log = new File(("Vehicles.csv"));
        try{
            if (!log.exists()){
                System.out.println("no file found, need new file");
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("\n").append(getID()).append(",").append(Name).append(",").append(Fuel).append(",")
                    .append(CarryingCapacity).append(",").append(FuelCapacity).append(",").append(Type).append(",").append(CurrentPort);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
