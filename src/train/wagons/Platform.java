package train.wagons;

public class Platform extends Wagon {

    public static final double weight = 15;

    public Platform(int serialNumber) {
        super(serialNumber, weight);
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
