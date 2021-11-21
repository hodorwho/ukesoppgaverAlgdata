package eksempelklasser;

import java.util.Arrays;

public enum Maned {

    JAN(1, "Januar"),
    FEB(2, "Februar"),
    MAR(3, "Mars"),
    APR(4, "April"),
    MAI(5, "Mai"),
    JUN(6, "Juni"),
    JUL(7, "Juli"),
    AUG(8, "August"),
    SEP(9, "September"),
    OKT(10, "Oktober"),
    NOV(11, "November"),
    DES(12, "Desember");

    private final int mndnr; //instansvariabel
    private final String fulltnavn; //instansvariabel


    private Maned(int mndnr, String fulltnavn) {
         this.fulltnavn = fulltnavn;
         this.mndnr = mndnr;
    }

    @Override public String toString() {
        return fulltnavn;
    }

    public int mndnr() {return mndnr;}

    public static String toString(int mnd) {
        if (mnd < 1 || mnd > 12) throw
            new IllegalArgumentException("Ikke et mndnummer");

        return values()[mnd-1].toString();
    }

    // går <fra, til]
    public static Maned[] vår() {
        return Arrays.copyOfRange(values(), 3, 5);
    }

    public static Maned[] sommer() {
        return Arrays.copyOfRange(values(), 5, 8);
    }
    public static Maned[] høst() {
        return Arrays.copyOfRange(values(), 8, 10);
    }
    public static Maned[] vinter() {
        return new Maned[] {NOV, DES, JAN, FEB, MAR};
    }


    public static void main(String[] args) {

        for (Maned m : Maned.høst()) {
            System.out.println(m.toString() + " (" + m.name() + ") " + m.mndnr());
        }
    }
}