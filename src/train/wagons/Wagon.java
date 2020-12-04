package train.wagons;


public abstract class Wagon {

    public int serialNumber;
    public double weight;
    public int charactersAmount;

    public int getCharactersAmount(){ return charactersAmount; }
    public String getLine2(){ return null; }
    public String getLine3(){ return null; }
    public String getLine4(){ return null; }
    public String getLine5(){ return null; }

    public Wagon(int serialNumber, double weight) {
        this.serialNumber = serialNumber;
        this.weight = weight;

    }

    public boolean isLocomotive(){
        return false;
    }

}
