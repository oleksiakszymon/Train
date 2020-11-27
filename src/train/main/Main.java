package train.main;

import train.communication.Output;
import train.operations.Operations;
import train.exceptions.WrongPositionException;
import train.wagons.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Wagon> composition = new ArrayList<>();

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
                    try {
                        operations.addToComposition(composition);
                    } catch (WrongPositionException ex) {
                        System.out.println(ex.toString());
                    }
                }
                //Delete wagon
                case 2 -> operations.removeFromComposition(composition);
                //Show composition
                case 3 -> output.showComposition(composition);
                //Quit
                case 4 -> process = false;
            }
        }
    }
}