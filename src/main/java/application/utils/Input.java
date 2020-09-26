package application.utils;

import entity.City;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInt () {
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            scanner.nextLine();
            return a;
        }
        scanner.next();
        System.out.println(scanner.nextLine() + " - это не целое число. Повторите ввод");
        return getInt();
    }

    public static int getInt (String message) {
        System.out.println(message);
        return getInt();
    }


    public static double getDouble () {
        if (scanner.hasNextLine()) {
            double c = scanner.nextDouble();
            scanner.nextLine();
            return c;
        }
        scanner.next();
        System.out.println(scanner.nextLine() + " - - это не число. Повторите ввод");
        return getDouble();
    }

    public static double getDouble (String message) {
        System.out.println(message);
        return getDouble();
    }


    public static boolean getBoolean () {
        if (scanner.hasNextLine()) {
            boolean e = scanner.nextBoolean();
            scanner.nextLine();
            return e;
        }
        scanner.next();
        System.out.println(scanner.nextLine() + " - повторите ввод");
        return getBoolean();
    }

    public static boolean getBoolean (String message) {
        System.out.println(message);
        return getBoolean();
    }


    public static String getString () {
        if (scanner.hasNextInt()) {
            System.out.println(scanner.nextLine() + " - это не строка. Повторите ввод");
        }
        return scanner.nextLine();
    }

    public static String getString (String message) {
        System.out.println(message);
        return getString();
    }

}
