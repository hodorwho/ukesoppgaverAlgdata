package eksempelklasser;

import hjelpeklasser.Beholder;

import java.util.Iterator;

public abstract class AbstraktBeholder<T> implements Beholder<T>
{
    public abstract boolean leggInn(T t);    // en abstrakt metode

    public boolean inneholder(T t)
    {
    //3.1.2 oppg 1
        if (t == null) {
            for (T s : this) if (s == null) return true;
        }
        else {
            for (T s : this) if (t.equals(s)) return true;
        }
        return false;   // foreløpig kode
    }

    public boolean fjern(T t)
    {
        return false;   // foreløpig kode
    }

    public int antall()
    {
        return 0;   // foreløpig kode
    }

    public boolean tom()
    {
        return antall() == 0;   // ferdig kode
    }

    public void nullstill()
    {
        // foreløpig kode
    }

    public abstract Iterator<T> iterator();    // en abstrakt metode

    public String toString()
    {
        return null;   // foreløpig kode
    }
}