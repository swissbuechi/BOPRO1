package de.mobile.university.bopro1.aufgabe3;

public class PKW extends Fahrer {

    public PKW(String name,
               int basisgehalt,
               int einstellungsjahr) {
        super(name,
                basisgehalt,
                einstellungsjahr);
    }

    public PKW(PKW pkw) {
        super(pkw);
    }

    @Override
    public int gehalt() {
        return 0;
    }
}
