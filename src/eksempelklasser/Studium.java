package eksempelklasser;

public enum Studium  // legges under package eksempelklasser
{
    Data ("Ingeniørfag - data"),         // enumkonstanten Data
    IT ("Informasjonsteknologi"),        // enumkonstanten IT
    Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
    Elektro ("Ingeniørfag - elektronikk og informasjonsteknologi"),
    Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne

    private final String fulltnavn;      // instansvariabel
    private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

    public String toString() { return fulltnavn; }

    public static void main(String[] args) {
        // 1.4.5 oppg 1
        for (Studium s : Studium.values())
        {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
        // Ingeniørfag - data (Data)
        // Informasjonsteknologi (IT)
        // Anvendt datateknologi (Anvendt)
        // Enkeltemnestudent (Enkeltemne)
    }

}



