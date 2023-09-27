package System_admin.Add;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AddContainers {
    //generated Containers ID
    private String ID;

    public String getID() {
        return ID;
    }

    public void ContainersID() {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Containers.csv"));
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

    public void addContainers() {
        ContainersID();
        //Input items information
        Scanner scanner = new Scanner(System.in);
        System.out.println("Weight: ");
        String Weight = scanner.nextLine();
        System.out.println("Fuel consumption:");
        String FuelConsum = scanner.nextLine();
        System.out.println("Type: ");
        String Type= scanner.nextLine();
        //append new information to csv file
        File log = new File(("Containers.csv"));
        try{
            if (!log.exists()){
                System.out.println("no file found, need new file");
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(getID()).append(",").append(Weight).append(",").append(FuelConsum).append(",").append(Type)
                    .append("\n");
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
