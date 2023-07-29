package de.mobile.university.bopro1.aufgabe3;

public class PkwMitHänger extends PKW {

    private int maxLadung; // Auf setter verzichtet
    // sollte nicht geändert werden können

    public PkwMitHänger(String name,
                        int basisgehalt,
                        int einstellungsjahr,
                        int maxLadung) {
        super(name,
                basisgehalt,
                einstellungsjahr);
        this.maxLadung = maxLadung;
    }

    public PkwMitHänger(PkwMitHänger pkwMitHänger) {
        super(pkwMitHänger);
        this.maxLadung = pkwMitHänger.maxLadung;
    }

    public int getMaxLadung() {
        return maxLadung;
    }

    @Override
    public int gehalt() {
        if (this.maxLadung > 750) {
            return (int) (this.getBasisgehalt() * 1.03);
        }
        return this.getBasisgehalt();
    }
}
