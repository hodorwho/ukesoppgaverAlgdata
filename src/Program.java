import hjelpeklasser.*;

import java.io.IOException;

import static hjelpeklasser.Tabell.randPerm;

public class Program
{
    // skriver ut et (sortert) array)
    public static void printArray(int a[]) {
        int n = a.length;
        for (int i=0; i<n; ++i) {
            System.out.print(a[i]+" ");
            //System.out.println();
        }
    }

    public static void main(String [] args) // throws IOException  // hovedprogram
    {
        /*
         // int[] a = {2,3,4,5};
         // int[] a = null;
            int[] a = randPerm(10);
            int[] c = null;

            //  Tabell.maks(a, -1, 10); //"ArrayIndexOutOfBoundsException"
            //  Tabell.maks(a, 2, 1); //"IllegalArgumentException"
            //  Tabell.maks(a, 0, 0); //"NoSuchElementException"
            //  Tabell.maks(c, 0,0); //"NullPointerException"
            //  Tabell.maks(a, 0, 0); //"NullPointerException" når a= null
                Tabell.maks(a, 1, 3);

        }

         */

   /*     // programkode 1.2.4 b (oppg 1)
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);*/

        // testing av SelectionSort for å se hvordan det fungerer
        int [] a = Tabell.randPerm(20);
        Tabell.SelectionSort(a);
        System.out.println("sorted array:");
        printArray(a);
    }
}
