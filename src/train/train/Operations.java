package train.train;

import train.exceptions.WrongPositionException;
import train.wagons.*;

public class Operations {

    public boolean wrongWagonPositionChecker(int position){
        if(!Train.train.isEmpty() && Train.train.get(0).isLocomotive() && position == 1) {
            return true;
        }
        return !Train.train.isEmpty() && Train.train.get(Train.train.size() - 1).isLocomotive() && Train.train.size() > 1 && position > Train.train.size();

    }

    public boolean wrongLocomotivePositionChecker(int position){

        if (!Train.train.isEmpty() && Train.train.get(0).isLocomotive() && Train.train.get(Train.train.size() - 1).isLocomotive() && Train.train.size() > 1){
            return true;
        }
        return position != 1 && position != Train.train.size() + 1;
    }

    public void addToTrain(WagonType type, int position, int serialNumber) throws WrongPositionException {

        switch (type) {
            case LOCOMOTIVE -> {
                if(wrongLocomotivePositionChecker(position)){
                    throw new WrongPositionException("Locomotive must be on 1st or last place\n");
                } else {
                    Train.train.add(position - 1, new Locomotive(serialNumber));
                }
            }
            case CISTERN -> {
                if(wrongWagonPositionChecker(position)) {
                    throw new WrongPositionException("You cannot place wagon behind last or before first locomotive\n");
                } else {
                    Train.train.add(position - 1, new Cistern(serialNumber));
                }
            }
            case COALWAGON -> {
                if(wrongWagonPositionChecker(position)) {
                    throw new WrongPositionException("You cannot place wagon behind last or before first locomotive\n");
                } else {
                    Train.train.add(position - 1, new CoalWagon(serialNumber));
                }
            }
            case PLATFORM -> {
                if(wrongWagonPositionChecker(position)) {
                    throw new WrongPositionException("You cannot place wagon behind last or before first locomotive\n");
                } else {
                    Train.train.add(position - 1, new Platform(serialNumber));
                }
            }
            default -> System.out.println("Invalid type.");
        }
    }

    public void removeFromTrain(int serialNumber) {
        for (Wagon wagon : Train.train) {
            if(wagon.serialNumber == serialNumber){
                Train.train.remove(wagon);
            }
        }
    }
}
