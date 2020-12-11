package train.wagons;

public class Cistern extends Wagon {

    public Cistern(int serialNumber) {
        super(serialNumber);
        setWeight(20);
        setMaxLoad(62);
    }

    @Override
    public int getCharactersAmount() { return 8; }
    @Override
    public String getLine2() { return "        ";}
    @Override
    public String getLine3() { return " ______ ";}
    @Override
    public String getLine4() { return "(______)";}
    @Override
    public String getLine5() { return " oo  oo ";}

}
