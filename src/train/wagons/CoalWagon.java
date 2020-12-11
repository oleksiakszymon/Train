package train.wagons;

public class CoalWagon extends Wagon {


    public CoalWagon(int serialNumber) {
        super(serialNumber);
        setWeight(18);
        setMaxLoad(100);
    }

    @Override
    public int getCharactersAmount() { return 8; }
    @Override
    public String getLine2() { return "        ";}
    @Override
    public String getLine3() { return "________";}
    @Override
    public String getLine4() { return "|______|";}
    @Override
    public String getLine5() { return " oo  oo ";}

}
