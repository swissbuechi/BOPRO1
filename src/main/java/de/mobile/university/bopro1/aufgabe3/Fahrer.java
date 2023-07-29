package de.mobile.university.bopro1.aufgabe3;

public abstract class Fahrer {
    private String pnr; // Auf setter verzichtet,
    // sollte nicht geändert werden können

    private String name;
    private int basisgehalt;
    private final int einstellungsjahr; // Auf setter verzichtet
    // sollte nicht geändert werden können

    public Fahrer(String name,
                  int basisgehalt,
                  int einstellungsjahr) {
        this.pnr = "0";
        this.name = name;
        this.basisgehalt = basisgehalt;
        this.einstellungsjahr = einstellungsjahr;
    }

    public Fahrer(Fahrer fahrer) {
        this.pnr = fahrer.pnr;
        this.name = fahrer.name;
        this.basisgehalt = fahrer.basisgehalt;
        this.einstellungsjahr = fahrer.einstellungsjahr;
    }

    public String getPnr() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasisgehalt() {
        return basisgehalt;
    }

    public void setBasisgehalt(int basisgehalt) {
        this.basisgehalt = basisgehalt;
    }

    public int getEinstellungsjahr() {
        return einstellungsjahr;
    }

    public abstract int gehalt();
}
