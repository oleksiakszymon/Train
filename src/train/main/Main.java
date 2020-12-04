package train.main;

import train.communication.Output;
import train.exceptions.SerialNumberTaken;
import train.train.Operations;
import train.exceptions.WrongPositionException;
import train.train.Train;
import train.wagons.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Output output = new Output();
        Operations operations = new Operations();

        boolean process = true;

        while (process) {

            System.out.println("What do you want to do?");
            output.listOptions();

            Scanner scan = new Scanner(System.in);
            String no = scan.nextLine();

            switch (Integer.parseInt(no)) {
                //Add wagon
                case 1 -> {
                    int serialNumber;
                    System.out.println("What type: LOCOMOTIVE, CISTERN, COALWAGON, PLATFORM");
                    String input = scan.next();
                    WagonType type;
                    try{
                        type = WagonType.valueOf(input.toUpperCase());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Invalid type");
                        continue;
                    }
                    System.out.println("What position: ");
                    int position = Integer.parseInt(scan.next());

                    try {
                        serialNumber = output.enterSerialNumber();
                    } catch (SerialNumberTaken ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    }

                    try {
                        operations.addToTrain(type, position, serialNumber);
                    } catch (WrongPositionException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                //Delete wagon
                case 2 -> {
                    System.out.print("Serial number: ");
                    String serialNumber = scan.nextLine();
                    operations.removeFromTrain(Integer.parseInt(serialNumber));
                }
                //Show composition
                case 3 -> output.showVisualisation(Train.train);
                //Quit
                case 4 -> process = false;
            }
        }
    }
}