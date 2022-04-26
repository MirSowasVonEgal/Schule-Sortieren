import java.util.Arrays;

public class FindWorstCase {

    // Jedes mögliche Array mit vollen Zahlen und einer länge von 10 soll erzeugt werden.

    // Nicht Fertig...

    public static void main(String[] args) {
        int[] feld = new int[10];
        resetArray(feld);
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld.length; j++) {
                int save = feld[i];
                feld[i] = feld[j];
                feld[j] = save;
                System.out.println(Arrays.toString(feld));
                resetArray(feld);
            }
        }
        Sortieren sortieren = new Sortieren(feld);
        sortieren.straightInsertion();
    }

    public static void resetArray(int[] feld) {
        for (int i = 0; i < feld.length; i++) {
            feld[i] = i;
        }
    }

}
