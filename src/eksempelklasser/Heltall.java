package eksempelklasser;

import hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Comparator;

public final class Heltall implements Comparable<Heltall>
{
    private final int verdi;    // et heltall som instansvariabel

    public Heltall(int verdi) { this.verdi = verdi; }   // konstruktør

    public int intVerdi() { return verdi; }             // aksessor

    public int compareTo(Heltall h)        // Heltall som parameter
    {
        /*
        if (verdi < h.verdi) return -1;
        else if (verdi == h.verdi) return 0;
        else return 1;
        */
        return verdi < h.verdi ? -1 : (verdi == h.verdi ? 0 : 1);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;   // sammenligner med seg selv
        if (!(o instanceof Heltall)) return false;  // feil datatype
        return verdi == ((Heltall)o).verdi;
    }

    public boolean equals(Heltall h) { return verdi == h.verdi; }

    public int hashCode() { return 31 + verdi; }

    public String toString() { return Integer.toString(verdi); }


    public static void main(String[] args) {
/*        int[] a = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) h[i] = new Heltall(a[i]);
        Tabell.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift*/

        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabell.innsettingssortering(d, Comparator.naturalOrder());
        System.out.println(Arrays.toString(d));
        //for (Double t : d) System.out.print(t + " "); System.out.println();
        Tabell.innsettingssortering(d, Comparator.reverseOrder());
        System.out.println(Arrays.toString(d));
        //for (Double t : d) System.out.print(t + " "); System.out.println();

        Boolean[] b = {false, true, true, false, false, true, false, true};
        Tabell.innsettingssortering(b, Comparator.naturalOrder());
        for (Boolean t : b) System.out.print(t + " ");

/*        // 1.4.8 oppg 4 - bruk deretter så strenger med samme lengde sorteres alfabetisk
        String [] sT = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(sT, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println();
        System.out.println(Arrays.toString(sT));
        //Komparator<sT> komS = Komparator.orden(String:: length).deretter(Komparator.naturligOrden());
        //Tabell.innsettingssortering(strin, Komparator.orden(String::length));*/

        System.out.println();
        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));
    }

} // class Heltall