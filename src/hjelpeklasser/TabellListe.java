package hjelpeklasser;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

//tabelliste: 3.2.2 oppg 1
//error: abstrract?0
//public class TabellListe<T> implements Liste<T> {
    /*private T[] a;
    private int antall;
    private int endringer;    // ny variabel

    // konstruktører og metoder kommer her

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse)       // konstruktør
    {
        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe()                    // standardkonstruktør
    {
        this(10);                             // startstørrelse på 10
    }


    public TabellListe(T[] b)                    // en T-tabell som parameter
    {
        this(b.length);                            // kaller den andre konstruktøren

        for (T verdi : b)
        {
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }

    public int antall()
    {
        return antall;          // returnerer antallet
    }

    public boolean tom()
    {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }
    public int indeksTil(T verdi)
    {
        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }

    // Skal ligge som en indre klasse i class TabellListe
    private class TabellListeIterator implements Iterator<T>
    {
        private int denne = 0;       // instansvariabel
        private int iteratorendringer = endringer;  // ny variabel
        private boolean fjernOK = false;   // ny instansvariabel i TabellListeIterator

        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        public T next()
        {
            if (iteratorendringer != endringer)
            {
                throw new ConcurrentModificationException("Listen er endret!");
            }

            if (!hasNext())
            {
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
            }

            T denneVerdi = a[denne];   // henter aktuell verdi
            denne++;                   // flytter indeksen
            fjernOK = true;            // nå kan remove() kalles
            return denneVerdi;         // returnerer verdien
        }

        public void remove()
        {
            if (iteratorendringer != endringer) throw new
                    ConcurrentModificationException("Listen er endret!");

            if (!fjernOK) throw
                    new IllegalStateException("Ulovlig tilstand!");

            fjernOK = false;           // remove() kan ikke kalles på nytt

            // verdien i denne - 1 skal fjernes da den ble returnert i siste kall
            // på next(), verdiene fra og med denne flyttes derfor en mot venstre

            antall--;           // en verdi vil bli fjernet
            denne--;            // denne må flyttes til venstre

            // tetter igjen
            System.arraycopy(a, denne + 1, a, denne, antall - denne);

            a[antall] = null;   // verdien som lå lengst til høyre nulles

            endringer++;
            iteratorendringer++;
        }
    }  // TabellListeIterator



    public Iterator<T> iterator()
    {
        return new TabellListeIterator();
    }


    public static void main(String[] args) {
        String[] s = {"Sohil",null,"Per","Thanh","Ann","Kari","Jon",null};
        Liste<String> liste = new TabellListe<>(s);
        // liste inneholder nå: "Sohil","Per","Thanh","Ann","Kari","Jon"

        System.out.println(liste.hent(4));
        System.out.println(liste.indeksTil("Kari"));
        System.out.println(liste.inneholder("Kari"));
    }
*/
//}