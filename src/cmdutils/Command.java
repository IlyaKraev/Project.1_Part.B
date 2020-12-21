package cmdutils;

import java.util.Scanner;

public class Command {

    public String getField(Scanner sc, String message) {
        System.out.println(message);
        return (sc.nextLine());
    }

    public double getDoubleField(Scanner sc, String message) {
        System.out.println(message);
        return (Double.parseDouble(sc.nextLine()));
    }

    public int getIntField(Scanner sc, String message) {
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input!");
            sc.next();
        }
        return (sc.nextInt());
    }

}
