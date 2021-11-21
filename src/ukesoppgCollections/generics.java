package ukesoppgCollections;

import eksempelklasser.Comparator;
import hjelpeklasser.EnkeltLenketListe;
import hjelpeklasser.Liste;
import hjelpeklasser.Tabell;

import java.util.Arrays;

public class generics {


    // 1.4.1. a) teste ut tilhørende kode i Tabell
    public static void main(String[] args) {

/*
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] c = "HELENE".toCharArray();
        Integer[] b = {5,2,7,3,9,1,8,4,6};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s
        int n = Tabell.maks(c);     // char tabell - oppgave 2
        int o = Tabell.maks(b);     // integer tabell - oppgave 3

        System.out.println(a[k] + "  " + d[l] + "  " + s[m]+ "  " + c[n]+ "  " + b[o]);
*/


        String[] s = {"Sohil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
        int k = Tabell.maks(s);        // hvilken maks-metode?
        System.out.println(s[k]);      // Utskrift:  Thanh

        String[] z = {"Per", "Kari", "Ole", "Anne", "Ali", "Eva"};
        Tabell.innsettingssortering(z);
        System.out.println(Arrays.toString(z));  // [Ali, Anne, Eva, Kari, Ole, Per]

        // oppgave 4 - testing av compareTo
        Integer x = 4, y = 4;
        System.out.print(x.compareTo(y));

        System.out.println();
        //1.4.3 testing av randperm for tabeller
        Integer[] a = Tabell.randPermInteger(10);
        System.out.println(Arrays.toString(a));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        //samme som over
        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        //1.4.3 oppg 7 - funker ikke men er tilsvarend fasit
        double[] d1 = {5.7, 3.14, 7.12, 3.9, 6.5, 7.1, 7.11};

        Double[] d = new Double[d1.length];
        for (int i = 0; i < d.length; i++) d[i] = d1[i];

        Tabell.innsettingssortering(d);
        System.out.println("skrivln sortert Double[]:");
        Tabell.skrivln(d);
        System.out.println();

        //oppgave 5 - testing av compareTo i String
        /*
         * Hvis lengdene har like tegn men er av forskjellig lengde, som
         * Kari og Karianne, vil diff mellom lengden returneres
         * ellers vil diff mellom plasseringen i ASCII returneres, altså
         * A.compareTo(B) = A-B
         */
        String t = "A", q = "a";
        System.out.print(t.compareTo(q));

        //Oppgave 6 - skal bli -1 siden false er mindre enn true
        System.out.println(Boolean.compare(false, true));

        // 1.4.7 h)
        String[] stri = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //Tabell.innsettingssortering(s, Komparator.orden(String::length));
        System.out.println(" komparator omvendt:");
        //oppgave 5: lange strenger først
        Tabell.innsettingssortering(stri, (xx,yy) -> yy.length() - xx.length());

        System.out.println(Arrays.toString(stri));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]


            //instans av klassen Integer 3.3.2 oppg 4)
            Liste<Integer> liste = new EnkeltLenketListe<>();

            System.out.println("antall i listen: " + liste.antall());
            System.out.println("Tall i listen: " + liste);

            //verdi er hvor den starter, så i+1 er på 1(første plass) etc
            for(int i = 0; i <10; i++) liste.leggInn(i+1);
            System.out.println("antall i listen: " + liste.antall());
            System.out.println("Tall i listen: " + liste);

            liste.nullstill();
            System.out.println("antall i listen: " + liste.antall());

            for(int i = 0; i <10; i++) liste.leggInn(liste.antall()/2, i+1);
            System.out.println("antall i listen: " + liste.antall());
            System.out.println("Tall i listen: " + liste);

    }
}