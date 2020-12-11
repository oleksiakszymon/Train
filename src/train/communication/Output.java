package train.communication;

import train.exceptions.SerialNumberTaken;
import train.train.Train;
import train.wagons.*;
import java.util.Scanner;

public class Output {

    Train train;

    public Output(Train train) {
        this.train = train;
    }

    public double totalMass = 0;
    int i = 0;

    Scanner scan = new Scanner(System.in);

    public void listOptions() {
        System.out.println("1. Add wagon");
        System.out.println("2. Delete wagon");
        System.out.println("3. Load wagon");
        System.out.println("4. Unload wagon");
        System.out.println("5. Show composition");
        System.out.println("6. Quit");
    } //lists train menu

    public int enterSerialNumber() throws SerialNumberTaken {
        System.out.println("Serial number: ");
        String serialNumber = scan.nextLine();
        for (Wagon wagon : train.getList()) {
            if(wagon.getSerialNumber() == Integer.parseInt(serialNumber)) {
                throw new SerialNumberTaken("Serial number is already taken");
            }
        }
        return Integer.parseInt(serialNumber);
    } //asks for serial number and checks if taken

    private boolean isOnlyOneEven(int x, int y){
        return (x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0);
    } //checks if only on number of given can be divided by 2

    private String serialNumberLine(Wagon e) {
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (e.getCharactersAmount() - Integer.toString(e.getSerialNumber()).length()) / 2; i++) {
            output.append(" ");
        }
        if (isOnlyOneEven(e.getCharactersAmount(), Integer.toString(e.getSerialNumber()).length())) {output.append(" ");}
        output.append(e.getSerialNumber());
        for(i = 0; i < (e.getCharactersAmount() - Integer.toString(e.getSerialNumber()).length()) / 2; i++) {
            output.append(" ");
        }
        return output.toString();
    } //generates serial number line of given wagon in visualisation
    private String wagonWeightLine(Wagon e) {
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (e.getCharactersAmount() - Double.toString(e.getWeight()).length() - 1) / 2; i++) {
            output.append(" ");
        }
        if (isOnlyOneEven(e.getCharactersAmount(),Double.toString(e.getWeight()).length() + 1)) {output.append(" ");}
        output.append(e.getWeight()).append("t");
        for(i = 0; i < (e.getCharactersAmount() - Double.toString(e.getWeight()).length() - 1) / 2; i++) {
            output.append(" ");
        }
        return output.toString();
    } //generates wagon weight line of given wagon in visualisation
    private String totalWagonMassLine(Wagon e) {
        StringBuilder output = new StringBuilder();
        Double total = e.getWeight() + e.getLoad();
        for(i = 0; i < (e.getCharactersAmount() - String.valueOf(total).length() - 1) / 2; i++) {
            output.append(" ");
        }
        if (isOnlyOneEven(e.getCharactersAmount(), String.valueOf(total).length() + 1)) {output.append(" ");}
        output.append(total).append("t");
        for(i = 0; i < (e.getCharactersAmount() - String.valueOf(total).length() - 1) / 2; i++){
            output.append(" ");
        }
        return output.toString();
    } //generates total mass line of given wagon in visualisation
    private String loadLine(Wagon e){
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (e.getCharactersAmount() - Double.toString(e.getLoad()).length() - 1) / 2; i++) {
            output.append(" ");
        }
        if (isOnlyOneEven(e.getCharactersAmount(),Double.toString(e.getLoad()).length() + 1)) {output.append(" ");}
        output.append(e.getLoad()).append("t");
        for(i = 0; i < (e.getCharactersAmount() - Double.toString(e.getLoad()).length() - 1) / 2; i++) {
            output.append(" ");
        }
        return output.toString();
    } //generates load line of given wagon in visualisation
    private String loadPercentLine(Wagon e) {
        StringBuilder output = new StringBuilder();
        float percent = Math.round((float) (e.getLoad() * 100 / e.getMaxLoad()));
        for(i = 0; i < (e.getCharactersAmount() - String.valueOf(percent).length() - 1) / 2; i++) {
            output.append(" ");
        }
        if (isOnlyOneEven(e.getCharactersAmount(), String.valueOf(percent).length() + 1)) {output.append(" ");}
        output.append(percent).append("%");
        for(i = 0; i < (e.getCharactersAmount() - String.valueOf(percent).length() - 1) / 2; i++){
            output.append(" ");
        }
        return output.toString();
    } //generates load percent line of given wagon in visualisation
    private String maxLoadLine(Wagon e){
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (e.getCharactersAmount() - Double.toString(e.getMaxLoad()).length() - 1) / 2; i++) {
            output.append(" ");
        }
        if (isOnlyOneEven(e.getCharactersAmount(), Double.toString(e.getMaxLoad()).length() + 1)) {output.append(
                " ");}
        output.append(e.getMaxLoad()).append("t");
        for(i = 0; i < (e.getCharactersAmount() - Double.toString(e.getMaxLoad()).length() - 1) / 2; i++) {
            output.append(" ");
        }
        return output.toString();
    } //generates max load line of given wagon in visualisation

    public void showVisualisation(Train train){

        StringBuilder r1 = new StringBuilder("Serial Number:");
        StringBuilder r2 = new StringBuilder("              ");
        StringBuilder r3 = new StringBuilder("              ");
        StringBuilder r4 = new StringBuilder("              ");
        StringBuilder r5 = new StringBuilder("              ");
        StringBuilder r6 = new StringBuilder("Wagon weight: ");
        StringBuilder r7 = new StringBuilder("Wagon load:   ");
        StringBuilder r8 = new StringBuilder("Max Load:     ");
        StringBuilder r9 = new StringBuilder("Load percent: ");
        StringBuilder r10 = new StringBuilder("Total Mass:   ");

        totalMass = 0;

        for (Wagon wagon : train.getList()) {
            r1.append(serialNumberLine(wagon));
            r2.append(wagon.getLine2());
            r3.append(wagon.getLine3());
            r4.append(wagon.getLine4());
            r5.append(wagon.getLine5());
            r6.append(wagonWeightLine(wagon));
            r7.append(loadLine(wagon));
            r8.append(maxLoadLine(wagon));
            r9.append(loadPercentLine(wagon));
            r10.append(totalWagonMassLine(wagon));

            if(train.getList().size() > 0){
                r1.append(" ");
                r2.append(" ");
                r3.append(" ");
                r4.append("-");
                r5.append(" ");
                r6.append(" ");
                r7.append(" ");
                r8.append(" ");
                r9.append(" ");
                r10.append(" ");
            }
            totalMass += wagon.getWeight();
        }
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);
        System.out.println(r7);
        System.out.println(r8);
        System.out.println(r9);
        System.out.println(r10);
        System.out.println();
    } //generates and shows visualisation of given train
}
