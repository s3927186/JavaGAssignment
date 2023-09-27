package System_admin.Add;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AddManagers {
    //generated Managers ID
    private String ID;

    public String getID() {
        return ID;
    }

    public void ManagersID() {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Manager.csv"));
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

    public void addManagers() {
        ManagersID();
        //Input items information
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String Name = scanner.nextLine();
        System.out.println("Password: ");
        String Password = scanner.nextLine();
        //append new information to csv file
        File log = new File(("Manager.csv"));
        try{
            if (!log.exists()){
                System.out.println("no file found, need new file");
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("\n").append(getID()).append(",").append(Name).append(",").append(Password);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
