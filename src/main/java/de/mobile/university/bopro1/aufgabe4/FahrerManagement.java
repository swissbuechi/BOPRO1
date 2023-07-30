package de.mobile.university.bopro1.aufgabe4;

import de.mobile.university.bopro1.aufgabe3.Fahrer;
import de.mobile.university.bopro1.aufgabe3.LKW;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FahrerManagement implements IFahrerManagement {

    private static final Set<String> usedPNRs = new HashSet<>();

    private Fahrer[] drivers;

    private int numberOfDrivers;

    public FahrerManagement(int numberOfDrivers) {
        this.drivers = new Fahrer[numberOfDrivers];
        this.numberOfDrivers = 0;
    }

    @Override
    public void addFahrer(Fahrer driver) {
        if (this.numberOfDrivers >= this.drivers.length) {
            int newSize = (Math.max((int)
                    (this.drivers.length * 1.1), this.drivers.length + 1));
            this.drivers = Arrays.copyOf(this.drivers, newSize);
        }

        String nextPersonalNumber = generateNextPersonalnummer();
        driver.setPnr(nextPersonalNumber);
        usedPNRs.add(nextPersonalNumber);

        this.drivers[this.numberOfDrivers] = driver;
        this.numberOfDrivers++;
    }

    @Override
    public void removeFahrer(String pnr) {
        for (int i = 0; i < this.numberOfDrivers; i++) {
            if (this.drivers[i].getPnr().equals(pnr)) {
                this.drivers[i].setPnr(null);
                for (int j = i; j < this.numberOfDrivers - 1; j++) {
                    this.drivers[j] = this.drivers[j + 1];
                }
                this.drivers[this.numberOfDrivers - 1] = null;
                this.numberOfDrivers--;
                break;
            }
        }
    }

    private String generateNextPersonalnummer() {
        int maxPnr = 0;
        for (String usedPnr : usedPNRs) {
            if (usedPnr.matches("PNR\\d+")) {
                int currentPnr = Integer.parseInt(
                        usedPnr.substring(3));
                if (currentPnr > maxPnr) {
                    maxPnr = currentPnr;
                }
            }
        }
        return "PNR" + (++maxPnr);
    }

    public int countFahrer() {
        return this.numberOfDrivers;
    }

    public int calculateGehalt() {
        int totalGehalt = 0;
        for (int i = 0; i < this.numberOfDrivers; i++) {
            totalGehalt += this.drivers[i].gehalt();
        }
        return totalGehalt;
    }

    public int anzahlPartner() {
        int countWithPartner = 0;
        for (int i = 0; i < this.numberOfDrivers; i++) {
            if (this.drivers[i] instanceof LKW &&
                    ((LKW) (this.drivers[i]))
                            .getPartner() != null) {
                countWithPartner++;
            }
        }
        return countWithPartner;
    }

    public Fahrer[] getDrivers() {
        return drivers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current state of drivers management array (size: ")
                .append(drivers.length).append("):\n");
        for (int i = 0; i < numberOfDrivers; i++) {
            if (drivers[i] != null) {
                sb.append("Driver ").append(i + 1)
                        .append(": ")
                        .append(drivers[i].getName())
                        .append(" (PNR: ")
                        .append(drivers[i].getPnr())
                        .append(")\n");
            } else {
                sb.append("Driver ")
                        .append(i + 1)
                        .append(": Empty\n");
            }
        }
        return sb.toString();
    }

}
