package de.mobile.university.bopro1.aufgabe3;

import java.time.Year;

public class LkwUeber7_5 extends LKW {

    private int summeKm; // Auf setter verzichtet
    // sollte nicht geändert werden können

    public LkwUeber7_5(String name,
                       int basisgehalt,
                       int einstellungsjahr,
                       int zuschlag, LKW partner) {
        super(name,
                basisgehalt,
                einstellungsjahr,
                zuschlag, partner);
    }

    public LkwUeber7_5(String name,
                       int basisgehalt,
                       int einstellungsjahr,
                       int zuschlag) {
        super(name, basisgehalt,
                einstellungsjahr,
                zuschlag);
    }

    public LkwUeber7_5(String name,
                       int basisgehalt,
                       int einstellungsjahr,
                       LKW partner) {
        super(name, basisgehalt,
                einstellungsjahr, partner);
    }

    public LkwUeber7_5(String name,
                       int basisgehalt,
                       int einstellungsjahr) {
        super(name, basisgehalt,
                einstellungsjahr);
    }

    public LkwUeber7_5(LkwUeber7_5 lkwUeber7_5) {
        super(lkwUeber7_5);
        this.summeKm = lkwUeber7_5.summeKm;
    }

    public int getSummeKm() {
        return summeKm;
    }

    public void fahre(int km) {
        this.summeKm += km;
    }

    @Override
    public int gehalt() {
        int yearsAsDriver = (Year.now().getValue() -
                this.getEinstellungsjahr());
        int timeBonus = yearsAsDriver * 100;
        int distanceBonus = (int) (this.summeKm * 0.0001);
        return this.getBasisgehalt() + timeBonus + distanceBonus;
    }
}
