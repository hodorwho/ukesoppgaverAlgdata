package eksempelklasser;

import hjelpeklasser.Tabell;
import java.util.*;
import eksempelklasser.Comparator;
import java.util.stream.Stream;

public class Person implements Comparable<Person> {
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        Objects.requireNonNull(fornavn, "fornavn kan ikke være null");
        Objects.requireNonNull(etternavn, "etternavn kan ikke være null");
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() {
        return fornavn;
    }       // aksessor

    public String etternavn() {
        return etternavn;
    }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
/*        if(fornavn == null){
            throw new NullPointerException("Fornavn kan ikke være tomt");
        }
        else if (etternavn == null) {
            throw new NullPointerException("Etternavn kan ikke være tomt");
        }*/

        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

/*    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;
    }*/

    // mer direkte versjon av equals
    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true; // er det samme objekt?
        if (o == null) return false; // null
        //if (!(o instanceof Person)) return false;
        if (getClass() != o.getClass()) return false; //er det rett klasse
        //return compareTo((Person)o) == 0;
        final Person p = (Person) o; //typekonvertering
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public boolean equals(Person p) {
        if (p == this) return true;
        if (p == null) return false;
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);

    }

    public int hashCode() {
        return Objects.hash(etternavn, fornavn);
    }

    public String toString() {
        return String.join(" ", fornavn, etternavn);
        //return fornavn + " " + etternavn;
    }

    // vil ikke kjøre i main hvis ikke student er static... vet ikke hvorfor
    public static class Student extends Person   // Student blir subklasse til Person
    {
        private final Studium studium;      // studentens studium

        public Student(String fornavn, String etternavn, Studium studium)
        {
            super(fornavn, etternavn);
            this.studium = studium;
        }

        public String toString() { return super.toString() + " " + studium.name();}

        public Studium studium() { return studium; }

    }  // class Student

    public static void main(String[] args) {
        /*Person[] p = new Person[8];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
        p[5] = new Person("Mari","Lorentzen");        // Kari Pettersen
        p[6] = new Person("","Jensen");        // Kari Pettersen
        p[7] = new Person("Dag Otto","Hansen");        // Kari Pettersen

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        Arrays.sort(p);
        System.out.println(Arrays.toString(p));
        // Utskrift:

        // Boris Zukanovic er størst
        // [Ali Kahn, Kari Pettersen, Kari Svendsen, Azra Zukanovic, Boris Zukanovic]

        // 1.4.4 oppg 2i)
        System.out.println("Stream:");
        Stream str = Arrays.stream(p);
        Optional<Person> resultat = str.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);

        // 1.4.4 oppg 2j)
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);*/

/*
        Student[] s = new Student[9];  // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
        s[5] = new Student("Amma", "Jensen", Studium.Elektro);     // Azra Zukanovic
        s[6] = new Student("Karl", "Persen", Studium.Elektro);   // Kari Pettersen
        s[7] = new Student("Anita", "Zansen", Studium.Enkeltemne);     // Azra Zukanovic
        s[8] = new Student("Kim", "Peteurs", Studium.Enkeltemne);   // Kari Pettersen


        Tabell.innsettingssortering(s, (s1,s2) ->
        {
            int cmp = s1.studium().compareTo(s2.studium());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        }
        );

        for (Student t: s) System.out.println(t);

        //etter studium, fornavn, etternavn
        Tabell.innsettingssortering(s, (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    if (k != 0) return k;
                    k = s1.fornavn().compareTo(s2.fornavn());
                    if (k != 0) return k;
                    return s1.etternavn().compareTo(s2.etternavn());
                }
        );

        for (Student t: s) System.out.println(t);

        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        //oppg 1
        Comparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
       // Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)
        //System.out.println(Arrays.toString(p));           // Utskrift av tabellen p

        // korta ned
       // Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        //System.out.println(Arrays.toString(p));

        System.out.println();

        Tabell.innsettingssortering(Comparator.comparing(Person::etternavn));
       // Tabell.innsettingssortering(p, Comparator.naturalOrder());
        //Comparator<Person> per = Comparator.comparing(Person::etternavn);
        System.out.println(Arrays.toString(p));*/
    }

} // class Person

