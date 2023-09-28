package com.game.util;

import java.util.Scanner;

public class ReadInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        return scanner.nextLine().trim();
    }
}
