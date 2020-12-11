package train.wagons;


public abstract class Wagon {

    private int serialNumber;
    private double weight;
    private int charactersAmount;
    private double load;
    private double maxLoad;

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCharactersAmount(int charactersAmount) {
        this.charactersAmount = charactersAmount;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getCharactersAmount(){ return charactersAmount; }
    public String getLine2(){ return null; }
    public String getLine3(){ return null; }
    public String getLine4(){ return null; }
    public String getLine5(){ return null; }

    public Wagon(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isLocomotive(){
        return false;
    }

}
