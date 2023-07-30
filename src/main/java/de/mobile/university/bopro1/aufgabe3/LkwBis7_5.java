package de.mobile.university.bopro1.aufgabe3;

import java.time.Year;

public class LkwBis7_5 extends LKW {
    public LkwBis7_5(String name,
                     int basisgehalt,
                     int einstellungsjahr,
                     int zuschlag,
                     LKW partner) {
        super(name, basisgehalt,
                einstellungsjahr,
                zuschlag, partner);
    }

    public LkwBis7_5(String name,
                     int basisgehalt,
                     int einstellungsjahr,
                     int zuschlag) {
        super(name, basisgehalt,
                einstellungsjahr, zuschlag);
    }

    public LkwBis7_5(String name,
                     int basisgehalt,
                     int einstellungsjahr,
                     LKW partner) {
        super(name, basisgehalt,
                einstellungsjahr,
                partner);
    }

    public LkwBis7_5(String name,
                     int basisgehalt,
                     int einstellungsjahr) {
        super(name, basisgehalt,
                einstellungsjahr);
    }

    public LkwBis7_5(LkwBis7_5 lkwBis7_5) {
        super(lkwBis7_5);
    }

    @Override
    public int gehalt() {
        int yearsAsDriver = (Year.now().getValue() -
                this.getEinstellungsjahr());
        return this.getBasisgehalt() + (yearsAsDriver * 100);
    }
}
