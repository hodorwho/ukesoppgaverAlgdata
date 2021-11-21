package eksempelklasser;

/*@FunctionalInterface                // legges i mappen eksempelklasser
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    int compare(T x, T y);            // en abstrakt metode
}*/

@FunctionalInterface
public interface Comparator<T>      // et funksjonsgrensesnitt
{
    // den abstrakte metoden
    int compare(T o1, T o2);          // en abstrakt metode

    //statiske metoder
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
    {
        return (x, y) -> x.compareTo(y);
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder()
    {
        return (x, y) -> y.compareTo(x);
    }

    // x og y er av typen T, imens anvend() returnerer R
    public static <T, R extends Comparable<? super R>>
    Comparator<T> comparing(Function<? super T, ? extends R> velger)
    {
        return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
    }

    public static <T, R> Comparator<T> comparing
            (Function<? super T, ? extends R> velger, Comparator<? super R> c)
    {
        return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
    }

    // default metoder:
    //deretter 1.4.8
    default Comparator<T> thenComparing(Comparator<? super T> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(x, y);
        };
    }

    //default sammenlignbar verdi R for datatypen T
    default <R extends Comparable<? super R>>  // tilhører grensesnittet Komparator
    Comparator<T> thenComparing(Function<? super T, ? extends R> velger)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
        };
    }

    default <R> Comparator<T>
    thenComparing(Function<? super T, ? extends R> velger, Comparator<? super R> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }

    default Comparator<T> omvendt()
    {
        return (x, y) -> compare(y, x);  // bytter x og y
    }

} // komparator

/*  1.4.7 f)
@FunctionalInterface
// T for argumenttype (eks Student) R for returtype (eks String for studium())
public interface Funksjon<T,R>    // T for argumenttype, R for returtype
{
    R anvend(T t);
}*/

