package train.train;

import train.exceptions.MaxLoadExceeded;
import train.exceptions.WrongPositionException;
import train.wagons.*;

import java.util.ArrayList;

public class Train {

        ArrayList<Wagon> train = new ArrayList<>();

        public ArrayList<Wagon> getList() {
            return(train);
        } //returns list of wagons of the train

        public boolean wrongWagonPositionChecker(int position){
            if(!train.isEmpty() && train.get(0).isLocomotive() && position == 1) {
                return true;
            }
            return !train.isEmpty() && train.get(train.size() - 1).isLocomotive() && train.size() > 1 && position > train.size();

        } //checks if user is trying to place wagon before first or behind last locomotive

        public boolean wrongLocomotivePositionChecker(int position){

            if (!train.isEmpty() && train.get(0).isLocomotive() && train.get(train.size() - 1).isLocomotive() && train.size() > 1){
                return true;
            }
            return position != 1 && position != train.size() + 1;
        } //checks if user is trying to place locomotive in other place than first or last

        public void addToTrain(WagonType type, int position, int serialNumber) throws WrongPositionException {

            switch (type) {
                case LOCOMOTIVE -> {
                    if(wrongLocomotivePositionChecker(position)){
                        throw new WrongPositionException("Locomotive must be on 1st or last place\n");
                    } else {
                        train.add(position - 1, new Locomotive(serialNumber));
                    }
                }
                case CISTERN -> {
                    if(wrongWagonPositionChecker(position)) {
                        throw new WrongPositionException("You cannot place wagon behind last or before first locomotive\n");
                    } else {
                        train.add(position - 1, new Cistern(serialNumber));
                    }
                }
                case COALWAGON -> {
                    if(wrongWagonPositionChecker(position)) {
                        throw new WrongPositionException("You cannot place wagon behind last or before first locomotive\n");
                    } else {
                        train.add(position - 1, new CoalWagon(serialNumber));
                    }
                }
                case PLATFORM -> {
                    if(wrongWagonPositionChecker(position)) {
                        throw new WrongPositionException("You cannot place wagon behind last or before first locomotive\n");
                    } else {
                        train.add(position - 1, new Platform(serialNumber));
                    }
                }
            }
        } //adds wagon to train

        public void removeFromTrain(int serialNumber) {
            train.removeIf(wagon -> wagon.getSerialNumber() == serialNumber);
        } //removes wagon from train

        public void loadWagon(int serialNumber, double loadAmount) throws MaxLoadExceeded {
            for(Wagon wagon : train){
                if (wagon.getSerialNumber() == serialNumber){
                    if(wagon.getLoad() + loadAmount > wagon.getMaxLoad()){
                        throw new MaxLoadExceeded("There is no available space for " + loadAmount + "t");
                    }
                    wagon.setLoad(wagon.getLoad() + loadAmount);
                }
            }
        } // loads wagon by serial number

        public void unloadWagon(int serialNumber, double unloadAmount) {
            for(Wagon wagon : train) {
                if (wagon.getSerialNumber() == serialNumber) {
                    wagon.setLoad(wagon.getLoad() - unloadAmount);
                    break;
                }
                System.out.println("Invalid serial number");
            }
        } // unloads wagon by serial number

        public void emptyWagon(int serialNumber) {
            for(Wagon wagon : train) {
                if (wagon.getSerialNumber() == serialNumber) {
                    wagon.setLoad(0);
                    continue;
                }
                System.out.println("Invalid serial number");
            }
        } // unloads entire wagon
    }
