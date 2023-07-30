package de.mobile.university.bopro1.aufgabe4;

import de.mobile.university.bopro1.aufgabe3.*;

public class FahrerManagementTest {
    public static void main(String[] args) {
        Fahrer fahrer1 = new LkwUeber7_5("Peter",
                1000, 2020);

        Fahrer fahrer2 = new LkwBis7_5("Hans",
                1000, 2020, (LKW) fahrer1);

        Fahrer fahrer3 = new PkwOhneHänger("Peter",
                1000, 2020);

        Fahrer fahrer4 = new PkwOhneHänger("Peter",
                1000, 2020);

        Fahrer fahrer5 = new PkwOhneHänger("Peter",
                1000, 2020);

        FahrerManagement fahrerManagement1 =
                new FahrerManagement(3);

        System.out.println("Adding fahrer1...");
        fahrerManagement1.addFahrer(fahrer1);
        System.out.println((fahrerManagement1));

        System.out.println("Adding fahrer2...");
        fahrerManagement1.addFahrer(fahrer2);
        System.out.println((fahrerManagement1));

        System.out.println("Adding fahrer3...");
        fahrerManagement1.addFahrer(fahrer3);
        System.out.println((fahrerManagement1));

        System.out.println("Total number of drivers: "
                + fahrerManagement1.countFahrer());
        System.out.println("Number of partners: "
                + fahrerManagement1.anzahlPartner());
        System.out.println("Total salary: "
                + fahrerManagement1.calculateGehalt());

        System.out.println("Removing fahrer with PNR1...");
        fahrerManagement1.removeFahrer("PNR1");
        System.out.println(fahrerManagement1);

        System.out.println("Adding fahrer1 again...");
        fahrerManagement1.addFahrer(fahrer1);
        System.out.println((fahrerManagement1));

        System.out.println("Adding fahrer4...");
        fahrerManagement1.addFahrer(fahrer4);
        System.out.println((fahrerManagement1));

        FahrerManagement fahrerManagement2 =
                new FahrerManagement(1);

        System.out.println("Adding fahrer5 to" +
                " the second FahrerManagement...");
        fahrerManagement2.addFahrer(fahrer5);
        System.out.println((fahrerManagement2));
    }
}
