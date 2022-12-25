package javabasiccourse.inputoutput.scanner;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        double sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            }
            else {
                scanner.next();
            }
        }
        System.out.printf(Locale.ENGLISH,"%.6f", sum);
    }
}
