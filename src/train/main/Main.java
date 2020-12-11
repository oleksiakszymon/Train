package train.main;

import train.communication.Output;
import train.exceptions.MaxLoadExceeded;
import train.exceptions.SerialNumberTaken;
import train.exceptions.WrongPositionException;
import train.train.Train;
import train.wagons.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Train train = new Train();
        Output output = new Output(train);

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
                    if(position > train.getList().size() + 1){
                        System.out.println("You can only place wagon on the next position to last wagon. (size is " + train.getList().size() + ")");
                        break;
                    }

                    try {
                        serialNumber = output.enterSerialNumber();
                    } catch (SerialNumberTaken ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    }

                    try {
                        train.addToTrain(type, position, serialNumber);
                    } catch (WrongPositionException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                //Delete wagon
                case 2 -> {
                    System.out.print("Serial number: ");
                    String serialNumber = scan.nextLine();
                    train.removeFromTrain(Integer.parseInt(serialNumber));
                }
                //Load wagon
                case 3 -> {
                    System.out.println("Which wagon do you want to load? (Serial Number)");
                    String wagonSelector = scan.next();
                    System.out.println("How much do you want to load?");
                    String loadAmount = scan.next();

                    try{
                        train.loadWagon(Integer.parseInt(wagonSelector), Double.parseDouble(loadAmount));
                    } catch (MaxLoadExceeded ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                //Unload wagon
                case 4-> {
                    System.out.println("Which wagon do you want to unload? (Serial Number)");
                    String wagonSelector = scan.next();
                    System.out.println("How much do you want to unload? (Type \"all\" to empty)");
                    String unloadAmount = scan.next();
                    if (unloadAmount.equals("all")) {
                        train.emptyWagon(Integer.parseInt(wagonSelector));
                    } else {
                        train.unloadWagon(Integer.parseInt(wagonSelector), Double.parseDouble(unloadAmount));
                    }

                }
                //Show composition
                case 5 -> output.showVisualisation(train);
                //Quit
                case 6 -> process = false;
            }
        }
    }
}