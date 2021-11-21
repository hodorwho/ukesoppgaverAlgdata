package hjelpeklasser;


import java.util.*;

public class Tabell     // Samleklasse for tabellmetoder
{
    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }
    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }
    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if (a == null) {
            throw new NullPointerException
                    ("tabellen er tom (null)");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    //nestMaks fra 1.2.4
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks


    public static int[] nestMaksSortert(int[] a)  // nestMaks edit, 1.2.4 oppg 2
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int f = a[0];
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        bytt(a, f, m); // bytter plass på m (største) og f, som er posisjon 0 i int []a
       // bytt (a, 0, m) // fra kompendiet

        nm = maks(a, 1, n);

        if ( nm == m) nm = 0; // hvis nest største lå først

        bytt(a,f,m); // bytter tilbake

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaksSortert

    /*
    tror jeg forstår denne: når man bytter plass er det bare kopiert inn,
    derfor vil man få et problem om nm er på posisjon en -
    fordi den vil da ikke sorteres gjennom
    når m er kopiert inn på plassen dens siden algoritmen begynner på pos 1
     */

    // oppgave 3: samme som over men her skal maks være sist, nm nest sist
    public static int[] nestMaksSortertSist(int[] a)  // nestMaks edit, 1.2.4 oppg 2
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int sist = a.length-1; //siste posisjon i arrayet
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        bytt(a, sist, m); // bytter plass på m og siste posisjon i array

        nm = maks(a, 0, sist); //legger (kopierer) m bakerst

        if ( nm == m) nm = sist; // hvis nest største lå bakerst

        bytt(a,sist,m); // bytter tilbake

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaksSortertSist

    // oppgave 4: selection sort basert på oppgave 3
    public static void SelectionSort(int[] a)  // nestMaks edit, 1.2.4 oppg 2
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

       // fasit:

        for (int i = n; i > 1; i--) { // n= a.length, går nedover fra a.length og stopper når i = 1
            int m = maks(a,0,i); // finn maks mellom pos 0 til i (som begynner på a.length og går ned til 1)
            bytt(a, i-1, m); // bytt m med i-1, altså
        }
    }
    // oppg 5: selection sort men den finner minste, setter den først etc
    public static void selectionSortBackwards(int[] a)
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        // fasit:

        for (int i = 0; i < n; i++) { // n= a.length, går nedover fra a.length og stopper når i = 1
            int m = min(a,i, n); // finn min mellom pos 0 til i (som begynner på a.length og går ned til 1)
            bytt(a, i, m); // bytt m med i
        }
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
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

    //bytt: 1.2.2 oppg 4

    public static void bytt(char[] c, int i, int j)
    {
        char temp = c[i]; c[i] = c[j]; c[j] = temp;
    }
// skriv

    public static void skriv(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        // fasit sier noe annet! spør om dette
        if (til - fra > 0) System.out.print(a[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);
    }

    public static void skriv(int[] a) // henter array? bruker hele arrayet?
    {
        skriv(a, 0, a.length);
    }

//skrivln

    public static void skrivln(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        System.out.println();
    }

    public static void skrivln(int[] a)
    {
        skrivln(a, 0, a.length);
    }

// fratilKontroll

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }

    //vhKontroll (sjekker gyldighet av lukket tabellintervall
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }
    // 4, 2, 13, 7 som skal snus - oppg6 1.2.3
    public static void snu(int[] a, int v, int h) {
    //husk at v og h er plasseringen ikke verdien!!

        vhKontroll(a.length, v, h);
        while (v < h) bytt (a, v++, h--);
    }

    // snur hele tabellen
    public static void snu(int[] a)
    {
        // v begynner på 0, h er på siste plass - definerer begrensningen/klemmen
        // [v,h]
        int v = 0, h = a.length-1;
        while (v < h) bytt (a, v++, h--);
    }
    // samme som over men med char
    public static void snu(char[] c, int v, int h) {
        //husk at v og h er plasseringen ikke verdien!!

        vhKontroll(c.length, v, h);
        while (v < h) bytt (c, v++, h--);
    }

    public static void snu(char[] c)
    {
        int v = 0, h = c.length-1;
        while (v < h) bytt (c, v++, h--);
    }

    public static int tverrsum(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }
/*    // 1.3.8 c) insettingssortering
    public static void innsettingssortering(int[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j+1] = a[j];  // sammenligner og flytter
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }*/

    //1.4.2 e) innsettingssortering fra utkommentert kode over,
    // gjort ved å endre til compareTo
    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    //1.4.6b innsettingssortering med komparator
    // compare som skal tilsvare compareTo i funksjonalitet
    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    //sorteingsalgoritmer med komparator
    //comparator-metoder for sorteringsalgoritmer
    //utvalgssortering ():

    //bytt
/*    public static <T> void bytt(T[] a, int i, int j) {
        T temp = a[i]; a[i] = a[j]; a[j] = temp;
    }*/
    // min-metode med T
    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c) {
        if (fra <0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra; //indeks til minste verdi
        T minverdi = a[fra]; //minste verdi

        for ( int i = fra+1; i < til; i++) if (c.compare(a[i], minverdi) < 0) {
            m = i;
            minverdi = a[m];
        }
        return m; // posisjonen til minste verdi i a[fra:til>
    }

    public static <T> int min(T[] a, Comparator<? super T> c)  // bruker hele tabellen
    {
        return min(a,0,a.length,c);     // kaller metoden over
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }


    //binærsøk
    public static <T> int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c) {
        Tabell.fratilKontroll(a.length, fra, til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h) / 2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m;                 // funnet
        }
        return -(v+1); // ikke funnet, v er relativt innsettingspunkt
    }

    //kaller metoden over!
    public static <T> int binærsøk(T[] a, T verdi, Comparator<? super T> c)
    {
        return binærsøk(a,0,a.length,verdi,c);  // bruker metoden over
    }

    //parter     //kvikksortering
    public static <T>
    int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (v <= h && c.compare(a[v],skilleverdi) < 0) v++;
        while (v <= h && c.compare(skilleverdi,a[h]) <= 0) h--;

        while (true)
        {
            if (v < h) Tabell.bytt(a,v++,h--); else return v;
            while (c.compare(a[v],skilleverdi) < 0) v++;
            while (c.compare(skilleverdi,a[h]) <= 0) h--;
        }
    }

    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c)
    {
        return parter(a,0,a.length-1,skilleverdi,c);  // kaller metoden over
    }

    public static <T>
    int sParter(T[] a, int v, int h, int k, Comparator<? super T> c)
    {
        if (v < 0 || h >= a.length || k < v || k > h) throw new
                IllegalArgumentException("Ulovlig parameterverdi");

        bytt(a,k,h);   // bytter - skilleverdien a[k] legges bakerst
        int p = parter(a,v,h-1,a[h],c);  // partisjonerer a[v:h-1]
        bytt(a,p,h);   // bytter for å få skilleverdien på rett plass

        return p;    // returnerer posisjonen til skilleverdien
    }

    public static <T>
    int sParter(T[] a, int k, Comparator<? super T> c)   // bruker hele tabellen
    {
        return sParter(a,0,a.length-1,k,c); // v = 0 og h = a.lenght-1
    }

    private static <T>
    void kvikksortering(T[] a, int v, int h, Comparator<? super T> c)
    {
        if (v >= h) return;  // hvis v = h er a[v:h] allerede sortert

        int p = sParter(a,v,h,(v + h)/2,c);
        kvikksortering(a,v,p-1,c);
        kvikksortering(a,p+1,h,c);
    }


    //flettesortering
    private static <T>
    void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c)
    {
        int n = m - fra;   // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;     // løkkevariabler og indekser

        while (i < n && j < til)  // fletter b[0:n> og a[m:til>, legger
            a[k++] = c.compare(b[i],a[j]) <= 0 ? b[i++] : a[j++];  // resultatet i a[fra:til>

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    public static <T>
    void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;     // a[fra:til> har maks ett element

        int m = (fra + til)/2;          // midt mellom fra og til

        flettesortering(a,b,fra,m,c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til,c);   // sorterer a[m:til>

        flett(a,b,fra,m,til,c);         // fletter a[fra:m> og a[m:til>
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);
        flettesortering(a,b,0,a.length,c);  // kaller metoden over
    }

    //1.4.a maks for int
    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    //1.4.1 b) - maks for String-verdier
    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    //1.4.1 oppgave 2 - maks av char-tabell basert på 1.4.a)
    public static int maks(char[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    //oppgave 3 basert på 1.4.1 b) for String - maks for Integer-tabell:
    public static int maks(Integer[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    // generic maks using T,  code 1.4.2 b)
    /* obs! Siden den extends comparable... vil den fungere for alle
    * typer input, og vil fungere dobbelt for feks String
    *dette fordi hvis det finnes flere metoder med samme signatur,
    * vil den første velges
    */
    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    //maks med T og komparator
    public static <T> int maks(T[] a, Comparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden nedenfor
    }

    public static <T> int maks(T[] a, int fra, int til, Comparator<? super T> c)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                // indeks til største verdi
        T maksverdi = a[fra];       // største verdi

        for (int i = fra + 1; i < til; i++)   // går gjennom intervallet
        {
            if (c.compare(a[i],maksverdi) > 0)  // bruker komparatoren
            {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdateres
            }
        }
        return m;                 // posisjonen til største verdi

    }  // maks

    // generic method for an array of random integers
    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

    // 1.4.3 oppg. 5: skriv ut [fra, til> med mellomrom
    public static void skriv(Object[]a, int fra, int til) {

        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    // 1.4.3 oppg. 5: skriv ut [fra, til> med linjeskift
    public static void skrivln(Object[] a, int fra, int til) {
        skriv(a, 0, a.length);
    }

    // 1.4.3 oppg. 5: skriv ut hele []a med mellomrom
    public static void skriv(Object[]a) {
        skriv(a,0,a.length);
    }

    // 1.4.3 oppg. 5: skriv ut hele []a med linjeskift
    public static void skrivln(Object[]a) {
        skrivln(a, 0, a.length);
    }

}
