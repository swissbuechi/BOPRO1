package de.mobile.university.bopro1.aufgabe3;

public class Aufgabe3Test {
    public static void main(String[] args) {
        Fahrer lkwUeber7_5 = new LkwUeber7_5("Peter",
                1000, 2020);
        ((LkwUeber7_5) lkwUeber7_5).fahre(1000000);
        System.out.println("LkwUeber7_5: Name: " + lkwUeber7_5.getName()
                + ", Basisgehalt: " + lkwUeber7_5.getBasisgehalt()
                + ", Einstellungsjahr: " + lkwUeber7_5.getEinstellungsjahr()
                + ", gefahrene Kilometer: " + ((LkwUeber7_5) lkwUeber7_5)
                .getSummeKm()
                + ", Gehalt: " + lkwUeber7_5.gehalt());

        Fahrer lkwUeber7_5Clone = new LkwUeber7_5((LkwUeber7_5) lkwUeber7_5);
        System.out.println("LkwUeber7_5Clone: Name: " + lkwUeber7_5Clone.getName()
                + ", Basisgehalt: " + lkwUeber7_5Clone.getBasisgehalt()
                + ", Einstellungsjahr: " + lkwUeber7_5Clone.getEinstellungsjahr()
                + ", gefahrene Kilometer: " + ((LkwUeber7_5) lkwUeber7_5Clone)
                .getSummeKm()
                + ", Gehalt: " + lkwUeber7_5Clone.gehalt());

        Fahrer lkwBis7_5 = new LkwBis7_5("Hans",
                1000, 2020, (LKW) lkwUeber7_5);
        System.out.println("LkwBis7_5: Name: " + lkwBis7_5.getName()
                + ", Basisgehalt: " + lkwBis7_5.getBasisgehalt()
                + ", Einstellungsjahr: " + lkwBis7_5.getEinstellungsjahr()
                + ", Partner: " + ((LKW) lkwBis7_5).getPartner().getName()
                + ", Gehalt: " + lkwBis7_5.gehalt());

        Fahrer pkwMitHänger = new PkwMitHänger("Fritz",
                1000, 2020, 1500);
        System.out.println("PkwMitHänger: Name: " + pkwMitHänger.getName()
                + ", Basisgehalt: " + pkwMitHänger.getBasisgehalt()
                + ", Einstellungsjahr: " + pkwMitHänger.getEinstellungsjahr()
                + ", Max Ladung: " + ((PkwMitHänger) pkwMitHänger).getMaxLadung()
                + ", Gehalt: " + pkwMitHänger.gehalt());

        Fahrer pkwOhneHänger = new PkwOhneHänger("Joel",
                1000, 2020);
        System.out.println("PkwOhneHänger: Name: " + pkwOhneHänger.getName()
                + ", Basisgehalt: " + pkwOhneHänger.getBasisgehalt()
                + ", Einstellungsjahr: " + pkwOhneHänger.getEinstellungsjahr()
                + ", Gehalt: " + pkwOhneHänger.gehalt());
    }
}