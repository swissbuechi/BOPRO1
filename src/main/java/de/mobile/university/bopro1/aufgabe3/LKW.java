package de.mobile.university.bopro1.aufgabe3;

public class LKW extends Fahrer {

    private int zuschlag;
    private LKW partner;

    public LKW(String name, int basisgehalt,
               int einstellungsjahr,
               int zuschlag, LKW partner) {
        super(name, basisgehalt, einstellungsjahr);
        this.zuschlag = zuschlag;
        this.partner = partner;
    }

    public LKW(String name, int basisgehalt,
               int einstellungsjahr,
               int zuschlag) {
        super(name, basisgehalt, einstellungsjahr);
        this.zuschlag = zuschlag;
    }

    public LKW(String name, int basisgehalt,
               int einstellungsjahr, LKW partner) {
        super(name, basisgehalt, einstellungsjahr);
        this.partner = partner;
    }

    public LKW(String name, int basisgehalt,
               int einstellungsjahr) {
        super(name, basisgehalt, einstellungsjahr);
    }

    public LKW(LKW lkw) {
        super(lkw);
        this.zuschlag = lkw.zuschlag;
        this.partner = lkw.partner;
    }

    public int getZuschlag() {
        return zuschlag;
    }

    public void setZuschlag(int zuschlag) {
        this.zuschlag = zuschlag;
    }

    public LKW getPartner() {
        return partner;
    }

    public void setPartner(LKW partner) {
        this.partner = partner;
    }

    @Override
    public int gehalt() {
        return 0;
    }
}
