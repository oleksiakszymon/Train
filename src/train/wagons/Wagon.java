package train.wagons;


public abstract class Wagon {

    public int serialNumber;
    public double weight;

    public Wagon(){

    }
    public Wagon(int serialNumber, double weight) {
        this.serialNumber = serialNumber;
        this.weight = weight;
    }


}
