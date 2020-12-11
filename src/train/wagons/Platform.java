package train.wagons;

public class Platform extends Wagon {

    public Platform(int serialNumber) {
        super(serialNumber);
        setWeight(12);
        setMaxLoad(50);
    }

    @Override
    public int getCharactersAmount() { return 11; }
    @Override
    public String getLine2() { return "           ";}
    @Override
    public String getLine3() { return "           ";}
    @Override
    public String getLine4() { return "|_________|";}
    @Override
    public String getLine5() { return " oo     oo ";}


}
