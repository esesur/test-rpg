package com.game;

import com.game.gameplay.Game;
import com.game.interaction.UserInterface;
import com.game.util.ReadInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        String input;
        userInterface.mainMenu();
        Game game = new Game();
        while (true) {
            if (game.isOver()) {
                game = new Game();
                userInterface.mainMenu();
                continue;
            }
            input = ReadInput.readInput();
            if (input.equals("start")) {
                game = new Game();
                game.start();
            } else if (input.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}