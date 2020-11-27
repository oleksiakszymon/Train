package train.communication;

import train.wagons.*;

import java.util.ArrayList;

public class Output {

    public double totalMass = 0;
    int i = 0;

    public void listWagons() {
        System.out.println("1. Locomotive");
        System.out.println("2. Cistern");
        System.out.println("3. Coal wagon");
        System.out.println("4. Platform");
    }
    public void listOptions() {
        System.out.println("1. Add wagon");
        System.out.println("2. Delete wagon");
        System.out.println("3. Show composition");
        System.out.println("4. Quit");
    }

    private String firstLine(Wagon e, int charAmount) {
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (charAmount - Integer.toString(e.serialNumber).length()) / 2; i++) {
            output.append(" ");
        }
        output.append(e.serialNumber);
        for(i = 0; i <(charAmount - Integer.toString(e.serialNumber).length()) / 2 || i %  2 == 0; i++) {
            output.append(" ");
        }
        return output.toString();
    }
    private String lastLine(Wagon e, int charAmount) {
        StringBuilder output = new StringBuilder();
        for(i = 0; i < (charAmount-Double.toString(e.weight).length()) / 2; i++) {
            output.append(" ");
        }
        output.append(e.weight).append("t");
        for(i = 0; i < (charAmount-Double.toString(e.weight).length() - 1) / 2 || i % 2 == 0; i++){
            output.append(" ");
        }
        return output.toString();
    }

    public void showComposition(ArrayList<Wagon> list) {

        int j = 0;
        ArrayList<String> r1 = new ArrayList<>();
        ArrayList<String> r2 = new ArrayList<>();
        ArrayList<String> r3 = new ArrayList<>();
        ArrayList<String> r4 = new ArrayList<>();
        ArrayList<String> r5 = new ArrayList<>();
        ArrayList<String> r6 = new ArrayList<>();

        for(Wagon e : list) {

            totalMass += e.weight;
            if (list.get(j).getClass() == Locomotive.class) {

                r1.add(firstLine(e, 16));
                r2.add("   oooo    _____");
                r3.add("  _I__n_n__||_||");
                r4.add(">(_________|_7_|");
                r5.add(" /o ()() ()() o ");
                r6.add(lastLine(e, 16));

            } else if (list.get(j).getClass() == Platform.class) {

                r1.add(firstLine(e, 11));
                r2.add("           ");
                r3.add("           ");
                r4.add("|_________|");
                r5.add(" oo     oo ");
                r6.add(lastLine(e, 11));

            } else if (list.get(j).getClass() == CoalWagon.class) {

                r1.add(firstLine(e, 8));
                r2.add("        ");
                r3.add("________");
                r4.add("|______|");
                r5.add(" oo  oo ");
                r6.add(lastLine(e, 8));

            } else if (list.get(j).getClass() == Cistern.class) {

                r1.add(firstLine(e, 8));
                r2.add("        ");
                r3.add(" ______ ");
                r4.add("(______)");
                r5.add(" oo  oo ");
                r6.add(lastLine(e, 8));
            }
            j++;
        }
        i = 0;
        for(String ignored : r1) {
            System.out.print(r1.get(i));
            if(i != r1.size() - 1){
                System.out.print(" ");
            }
            i++;
        }
        System.out.println();
        i = 0;
        for(String ignored : r2) {
            System.out.print(r2.get(i));
            if(i != r1.size() - 1){
                System.out.print(" ");
            }

            i++;
        }
        System.out.println();
        i = 0;
        for(String ignored : r3) {
            System.out.print(r3.get(i));
            if(i != r1.size() - 1){
                System.out.print(" ");
            }
            i++;
        }
        System.out.println();
        i = 0;
        for(String ignored : r4) {
            System.out.print(r4.get(i));
            if(i != r1.size() - 1){
                System.out.print("-");
            }
            i++;
        }
        System.out.println();
        i = 0;
        for(String ignored : r5) {
            System.out.print(r5.get(i));
            if(i != r1.size() - 1){
                System.out.print(" ");
            }
            i++;
        }
        System.out.println();
        i = 0;
        for(String ignored : r6) {
            System.out.print(r6.get(i));
            if(i != r1.size() - 1){
                System.out.print(" ");
            }
            i++;
        }
        System.out.println();
        System.out.println("Total mass: " + totalMass + "t\n");
        totalMass = 0;

    }
}
