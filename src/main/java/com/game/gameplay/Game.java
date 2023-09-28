package com.game.gameplay;

import com.game.entity.Player;
import com.game.interaction.UserInterface;
import com.game.util.ReadInput;

public class Game {
    private UserInterface userInterface = new UserInterface();
    private boolean game = true;
    private Player player;
    private String input;

    public void start() {
        init();
        userInterface.welcome();
        while (game) {
            input = ReadInput.readInput();
            switch (input) {
                case "fight":
                    new Battle(player);
                    if (!player.isAlive()) {
                        game = false;
                    }
                    break;
                case "exit":
                    userInterface.printExitMessage();
                    game = false;
                    break;
                case "stats":
                    userInterface.printPlayerStats(player);
                    break;
                case "help" :
                    userInterface.printHelp();
                    break;
                default:
                    userInterface.printUnknownCommand();
                    break;
            }
        }
    }

    private void init() {
        player = new Player(25, 20, 100,  5, 90);
    }

    public boolean isOver() {
        return !game;
    }
}
