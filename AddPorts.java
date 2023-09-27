package System_admin.Add;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AddPorts {
    //generated Ports ID
    private String ID;

    public String getID() {
        return ID;
    }

    public void PortID() {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Ports.csv"));
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

    public void addPorts() {
        PortID();
        //Input items information
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String Name = scanner.nextLine();
        System.out.println("latitude:");
        String Latitude = scanner.nextLine();
        System.out.println("longitude:");
        String Longitude = scanner.nextLine();
        System.out.println("Storing capacity: ");
        String StoreCapacity= scanner.nextLine();
        System.out.println("Landing ability: ");
        String LandingAbility= scanner.nextLine();
        //append new information to csv file
        File log = new File(("Ports.csv"));
        try{
            if (!log.exists()){
                System.out.println("no file found, need new file");
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("\n").append(getID()).append(",").append(Name).append(",").append(Latitude).append(",")
                    .append(Longitude).append(",").append(StoreCapacity).append(",").append(LandingAbility);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
