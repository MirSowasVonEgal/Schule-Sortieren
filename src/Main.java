import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Welche Zahlen willst du haben?");
        if(input == null) return;
        String[] inputFeld = input.split(" ");
        if(input.length() == 0) {
            JOptionPane.showMessageDialog(null, "Du musst mindestens 1 Zahl eingeben!");
            main(args);
            return;
        }
        int[] feld = new int[inputFeld.length+1];
        System.out.println(Arrays.toString(feld));
        System.out.println(output(feld) + " X");
        for (int i = 0; i < inputFeld.length; i++) {
            if(isInt(inputFeld[i])) {
                feld[i + 1] = Integer.parseInt(inputFeld[i]);
            } else {
                JOptionPane.showMessageDialog(null, "Du darfst nur Zahlen eingeben!");
                main(args);
                return;
            }
        }

        Sortieren sortieren = new Sortieren(feld.clone());
        sortieren.shakerSort();
        //sortieren.gnomSort();
        //sortieren.straightSelection();
        //sortieren.straightInsertion();
        //sortieren.bubbleSort();
        //sortieren.quickSort(1, feld.length-1);
        JOptionPane.showMessageDialog(null,
                "Eingabe: " + output(feld) + "\n" +
                        "Sortiert: " + output(sortieren.getFeld()) + "\n" +
                        "Z: " + sortieren.getZ() + "\n" +
                        "V: " + sortieren.getV() + "\n" +
                        "T: " + sortieren.getT() + "\n" +
                        "GZW: " + (sortieren.getZ() + 3 * sortieren.getT()));
        main(args);
    }

    private static String output(int[] feld) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < feld.length; i++) {
            output.append(" | ").append(feld[i]);
        }
        output.append(" |");
        return output.toString();
    }

    private static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
