package train.wagons;

public class Locomotive extends Wagon {

    public Locomotive(int serialNumber) {
        super(serialNumber);
        setWeight(25);
    }

    @Override
    public int getCharactersAmount() { return 16; }
    @Override
    public String getLine2() { return "   oooo    _____";}
    @Override
    public String getLine3() { return "  _I__n_n__||_||";}
    @Override
    public String getLine4() { return ">(_________|_7_|";}
    @Override
    public String getLine5() { return " /o ()() ()() o ";}

    @Override
    public boolean isLocomotive() {
        return true;
    }





}
