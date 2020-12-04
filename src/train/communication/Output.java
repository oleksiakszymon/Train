package train.communication;

import train.exceptions.SerialNumberTaken;
import train.train.Train;
import train.wagons.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Output {

    public double totalMass = 0;
    int i = 0;

    Scanner scan = new Scanner(System.in);

    public void listOptions() {
        System.out.println("1. Add wagon");
        System.out.println("2. Delete wagon");
        System.out.println("3. Show composition");
        System.out.println("4. Quit");
    }

    public int enterSerialNumber() throws SerialNumberTaken {
        System.out.println("Serial number: ");
        String serialNumber = scan.next();
        for (Wagon wagon : Train.train) {
            if(wagon.serialNumber == Integer.parseInt(serialNumber)) {
                throw new SerialNumberTaken("Serial number is already taken");
            }
        }
        return Integer.parseInt(serialNumber);
    }

    private String firstLine(Wagon e, int charAmount) {
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (charAmount - Integer.toString(e.serialNumber).length()) / 2; i++) {
            output.append(" ");
        }
        output.append(e.serialNumber);
        for(i = 0; i < (charAmount - Integer.toString(e.serialNumber).length()) / 2 || i %  2 == 0; i++) {
            output.append(" ");
        }
        return output.toString();
    }

    private String lastLine(Wagon e, int charAmount) {
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (charAmount - Double.toString(e.weight).length()) / 2; i++) {
            output.append(" ");
        }
        output.append(e.weight).append("t");
        for(i = 0; i < (charAmount - Double.toString(e.weight).length() - 1) / 2 || i % 2 == 0; i++){
            output.append(" ");
        }
        return output.toString();
    }

    public void showVisualisation(ArrayList<Wagon> list){
        for (Wagon wagon : list) {
            System.out.print(firstLine(wagon, wagon.getCharactersAmount()));
            if(list.size() > 0){
                System.out.print(" ");
            }
        }
        System.out.println();
        for (Wagon wagon : list) {
            System.out.print(wagon.getLine2());
            if(list.size() > 0){
                System.out.print(" ");
            }
        }
        System.out.println();
        for (Wagon wagon : list) {
            System.out.print(wagon.getLine3());
            if(list.size() > 0){
                System.out.print(" ");
            }
        }
        System.out.println();
        for (Wagon wagon : list) {
            System.out.print(wagon.getLine4());
            if(list.size() > 0){
                System.out.print("-");
            }
        }
        System.out.println();
        for (Wagon wagon : list) {
            System.out.print(wagon.getLine5());
            if(list.size() > 0){
                System.out.print(" ");
            }
        }
        System.out.println();
        for (Wagon wagon : list) {
            System.out.print(lastLine(wagon, wagon.getCharactersAmount()));
            if(list.size() > 0){
                System.out.print(" ");
            }
        }
        totalMass = 0;
        for (Wagon wagon : list) {
            totalMass += wagon.weight;
        }
        System.out.println();
        System.out.println("Total mass: " + totalMass + "t");
    }
}
