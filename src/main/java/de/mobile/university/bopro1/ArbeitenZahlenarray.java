package de.mobile.university.bopro1;

import java.util.Arrays;

public class ArbeitenZahlenarray {
    public static int anzahlGeradeZahlen(int[] ia) {
        int evenNumbers = 0;
        for (int number : ia) {
            if (number % 2 == 0) {
                evenNumbers++;
            }
        }
        return evenNumbers;
    }

    public static int letztePosition(int[] ia, int suche) {
        int index = -1;
        for (int i = ia.length; i-- > 0; ) {
            if (ia[i] == suche) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int[] ohneUngerade(int[] ia) {
        int[] evenArray = new int[anzahlGeradeZahlen(ia)];
        int index = 0;
        for (int num : ia) {
            if (num % 2 == 0) {
                evenArray[index] = num;
                index++;
            }
        }
        return evenArray;
    }

    public static int[] mischen(int[] ia1, int[] ia2) {
        int length = Math.max(ia1.length, ia2.length);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int value1 = i < ia1.length ? ia1[i] : Integer.MIN_VALUE;
            int value2 = i < ia2.length ? ia2[i] : Integer.MIN_VALUE;
            result[i] = Math.max(value1, value2);
        }
        return result;
    }

    public static int[] init(int v, int anz) {
        int[] resultArray = new int[anz];
        for (int i = 0; i < anz; i++) {
            resultArray[i] = v;
        }
        return resultArray;
    }

    public static int arrayInArray(int[] suche, int[] worin) {
        int length = suche.length;
        int index = worin.length - length;
        for (int i = 0; i <= index; i++) {
            int j;
            for (j = 0; j < length; j++) {
                if (worin[i + j] != suche[j]) {
                    break;
                }
            }
            if (j == length) {
                return i;
            }
        }
        return -1;
    }

    public static int arrayInArrayRev(int[] suche, int[] worin) {
        int length = suche.length;
        int index = worin.length - length;
        for (int i = index; i >= 0; i--) {
            int j;
            for (j = 0; j < length; j++) {
                if (worin[i + j] != suche[j]) {
                    break;
                }
            }
            if (j == length) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers0 = {8, 3, 5, 6, 8, 30, 5, 3, 5, 6};
        int[] numbers1 = {1, 3, 2, 2, 0, 50};
        int[] numbers2 = {3, 5, 6};

        System.out.println("Aufgabe 1A:");
        System.out.println("Numbers:"
                + Arrays.toString(numbers0));
        System.out.println("Test: anzahlGeradeZahlen: "
                + anzahlGeradeZahlen(numbers0));

        System.out.println("\nAufgabe 1B:");
        System.out.println("Numbers:" + Arrays.toString(numbers0));
        System.out.println("Test: letztePosition of number 5: "
                + letztePosition(numbers0, 5));

        System.out.println("\nAufgabe 1C:");
        System.out.println("Numbers:" + Arrays.toString(numbers0));
        System.out.println("Test: ohneUngerade: "
                + Arrays.toString(ohneUngerade(numbers0)));

        System.out.println("\nAufgabe 1D:");
        System.out.println("Numbers 0:" + Arrays.toString(numbers0));
        System.out.println("Numbers 1:" + Arrays.toString(numbers1));
        System.out.println("Test: mischen:"
                + Arrays.toString(mischen(numbers0, numbers1)));

        System.out.println("\nAufgabe 1E:");
        System.out.println("Test: init 3x 6: "
                + Arrays.toString(init(6, 3)));

        System.out.println("\nAufgabe 1F:");
        System.out.println("Numbers 1:" + Arrays.toString(numbers0));
        System.out.println("Numbers 2:" + Arrays.toString(numbers2));
        System.out.println("Test: arrayInArray: "
                + arrayInArray(numbers2, numbers0));

        System.out.println("\nAufgabe 1G:");
        System.out.println("Numbers 1:" + Arrays.toString(numbers0));
        System.out.println("Numbers 2:" + Arrays.toString(numbers2));
        System.out.println("Test: arrayInArrayRev: "
                + arrayInArrayRev(numbers2, numbers0));
    }
}

