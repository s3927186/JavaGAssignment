package System_admin.Remove;

import java.io.*;
import java.util.Scanner;

public class RemoveVehicle {
    public void removeVehicles(){
        String Line;
        try {
            Scanner scanner1 = new Scanner(new BufferedReader(new FileReader("Vehicles.csv")));
            while ((scanner1.hasNextLine())) {
                Line = scanner1.nextLine();
                System.out.println(Line);
            }
            scanner1.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("Which Vehicles do you want to remove?" + "\n Write \"back\" to go back");
            String choose = NewScanner.nextLine();
            if (choose.equalsIgnoreCase("back")) {
                System.out.println("go back");
            } else {
                try {
                    File log = new File(("ItemsTemp.csv"));
                    Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("Vehicles.csv")));
                    while ((scanner2.hasNextLine())) {
                        String details = scanner2.nextLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(choose.toLowerCase());
                        if (j == -1) {
                            try{
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(CurrentLine[0]).append(",").append(CurrentLine[1]).append(",")
                                        .append(CurrentLine[2]).append(",").append(CurrentLine[3]).append("\n");
                                out.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("Vehicle have been removed");
                        }
                    }scanner2.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Vehicles.csv"));
                    Scanner scanner3 = new Scanner(new BufferedReader(new FileReader("ItemsTemp.csv")));
                    while ((scanner3.hasNextLine())) {
                        String ItemSwitch = scanner3.nextLine();
                        writer.write(ItemSwitch + "\n");
                    }
                    writer.close();
                    scanner3.close();
                    BufferedWriter NewWriter = new BufferedWriter(new FileWriter("ItemsTemp.csv"));
                    NewWriter.write("");
                    NewWriter.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
