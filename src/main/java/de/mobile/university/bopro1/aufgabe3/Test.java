package de.mobile.university.bopro1.aufgabe3;

public class Test {
    public static void main(String[] args) {
        Fahrer lkwUeber7_5 = new LkwUeber7_5("Peter", 1000, 2020);
        ((LkwUeber7_5) lkwUeber7_5).fahre(1000000);
        System.out.println(lkwUeber7_5.gehalt());

        Fahrer lkwBis7_5 = new LkwBis7_5("Hans", 1000, 2020, (LKW) lkwUeber7_5);
        System.out.println(lkwBis7_5.gehalt());

        Fahrer pkwMitHänger = new PkwMitHänger("Fritz", 1000, 2020, 1500);
        System.out.println(pkwMitHänger.gehalt());

        Fahrer pkwOhneHänger = new PkwOhneHänger("Joel", 1000, 2020);
        System.out.println(pkwOhneHänger.gehalt());
    }
}