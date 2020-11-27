package train.operations;

import train.communication.Output;
import train.exceptions.WrongPositionException;
import train.wagons.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

    Output output = new Output();
    Scanner scan = new Scanner(System.in);
    private boolean checkSerialNumber(ArrayList<Wagon> composition, int serialNumber) {
        for (Wagon ignored : composition) {
            int i = 0;
            if(composition.get(i).serialNumber == serialNumber) {
                System.out.println("Serial number is already taken");
                return false;
            }
        }
        return true;
    }
    public void addToComposition(ArrayList<Wagon> composition) throws WrongPositionException {
        String serialNumber;
        output.listWagons();
        String type = scan.next();

        do {
            System.out.print("Serial number: ");
            serialNumber = scan.next();
        }  while (!checkSerialNumber(composition, Integer.parseInt(serialNumber)));

        System.out.print("Weight: ");
        String weight = scan.next();
        System.out.print("Position: ");
        String position = scan.next();
        System.out.println();

        switch (Integer.parseInt(type)) {
            case 1 -> { //Locomotive
                if(Integer.parseInt(position) != 1 && Integer.parseInt(position) != composition.size() + 1){
                    throw new WrongPositionException("Locomotive must be on 1st or last place\n");
                }
                else if(!composition.isEmpty() && composition.get(0).getClass() == Locomotive.class && composition.get(composition.size() - 1).getClass() == Locomotive.class && composition.size() > 1) {
                    throw new WrongPositionException("Locomotive must be on 1st or last place\n");
                }
                else {
                    composition.add(Integer.parseInt(position) - 1,
                            new Locomotive(Integer.parseInt(serialNumber),
                                    Double.parseDouble(weight)));
                }
            }
            case 2 -> { //Cistern
                if(!composition.isEmpty() && composition.get(composition.size() - 1).getClass() == Locomotive.class && composition.size() > 1 && Integer.parseInt(position) > composition.size()) {
                    throw new WrongPositionException("You cannot place wagon behind last locomotive\n");
                } else {
                    composition.add(Integer.parseInt(position) - 1, new Cistern(Integer.parseInt(serialNumber),
                            Double.parseDouble(weight)));
                }
            }
            case 3 -> { //Coal
                if(!composition.isEmpty() && composition.get(composition.size()-1).getClass()==Locomotive.class && composition.size()>1 && Integer.parseInt(position)>composition.size()) {
                    throw new WrongPositionException("You cannot place wagon behind last locomotive\n");
                } else {
                    composition.add(Integer.parseInt(position) - 1, new CoalWagon(Integer.parseInt(serialNumber),
                            Double.parseDouble(weight)));
                }
            }
            case 4 -> { //Platform
                if(!composition.isEmpty() && composition.get(composition.size() - 1).getClass() == Locomotive.class && composition.size() > 1 && Integer.parseInt(position) > composition.size()) {
                    throw new WrongPositionException("You cannot place wagon behind last locomotive\n");
                } else {
                    composition.add(Integer.parseInt(position) - 1, new Platform(Integer.parseInt(serialNumber),
                            Double.parseDouble(weight)));
                }
            }
        }
    }
    public void removeFromComposition(ArrayList<Wagon> composition) {
        System.out.print("Serial number: ");
        String serialNumber = scan.nextLine();
        composition.removeIf(Wagon -> Wagon.serialNumber == Integer.parseInt(serialNumber));
    }

}
