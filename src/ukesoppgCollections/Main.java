package ukesoppgCollections;

import hjelpeklasser.Tabell;

public class Main {

    public static void main(String[] args) {

        //tverrsum, oppgave 1.5.2 1)
        System.out.println("main() starter!");
        int sum = Tabell.tverrsum(72957);
        System.out.println("main() er ferdig!");
	// write your code here
    }
// tilsvarende 1.2.1 b)
public static int min(int[] a, int fra, int til) {
        if (fra <0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("ulovlig intervall!");
        }

        int min = fra;
        int minverdi = a[fra];

        for (int i = fra +1; i < til; i++) {
            if (a[i] < minverdi)
            {
                min = i;
                minverdi = a[min];
            }
        }

        return min;
}
    // tilsvarende 1.2.1 c)
    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }
}
