package de.mobile.university.bopro1.aufgabe3;

public class PkwOhneHänger extends PKW {

    public PkwOhneHänger(String name,
                         int basisgehalt,
                         int einstellungsjahr) {
        super(name, basisgehalt, einstellungsjahr);
    }

    public PkwOhneHänger(PkwOhneHänger pkwOhneHänger) {
        super(pkwOhneHänger);
    }

    @Override
    public int gehalt() {
        return this.getBasisgehalt();
    }
}
