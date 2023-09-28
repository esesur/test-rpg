package com.game.interaction;

import com.game.entity.Entity;
import com.game.entity.Player;
import com.game.util.AttackModifier;
import com.game.util.TablePrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInterface {
    private TablePrinter tablePrinter;

    public UserInterface() {
        tablePrinter = new TablePrinter();
    }

    public void welcome() {
        System.out.println("Welcome to the forest!");
        System.out.println("Type fight to find new monster for battle or help to show available commands");
    }

    public void printBattleInfo(Player player, Entity monster) {
        System.out.println("HP: Player - " + player.getHealth() + "/" + player.getMaxHealth() +
                " | Monster - " + monster.getHealth() + "/" + monster.getMaxHealth());
    }

    public void printPlayerStats(Player player) {
        List<String> headers = List.of("Player");
        List<List<String>> rows = new ArrayList<>();
        rows.add(List.of("ATK: " + player.getAttack()));
        rows.add(List.of("DEF: " + player.getDefense()));
        rows.add(List.of("HP: " + player.getHealth() + "/" + player.getMaxHealth()));
        rows.add(List.of(String.format("DMG: %d ~ %d", player.getMinDamage(), player.getMaxDamage())));
        rows.add(List.of("HEALS REMAIN: " + player.getAvailableHeals()));
        rows.add(List.of("DEFEATED MONSTERS: " + player.getDefeatedMonsters()));
        tablePrinter.print(headers, rows);
    }

    public void printBattleStats(Player player, Entity monster) {
        List<String> headers = Arrays.asList("Player", "Monster");
        List<List<String>> rows = new ArrayList<>();
        rows.add(Arrays.asList(
            "DEF: " + player.getDefense(),
            "DEF: " + monster.getDefense()
        ));
        rows.add(Arrays.asList(
            "ATK: " + player.getAttack(),
            "ATK: " + monster.getAttack()
        ));
        rows.add(Arrays.asList(
            "HP: " + player.getHealth() + "/" + player.getMaxHealth(),
            "HP: " + monster.getHealth() + "/" + monster.getMaxHealth()
        ));
        rows.add(Arrays.asList(
                String.format("DMG: %d ~ %d", player.getMinDamage(), player.getMaxDamage()),
                String.format("DMG: %d ~ %d", monster.getMinDamage(), monster.getMaxDamage())
        ));
        rows.add(Arrays.asList(
            "HEALS REMAIN: " + player.getAvailableHeals(),
            ""
        ));
        rows.add(Arrays.asList(
            "DEFEATED MONSTERS: " + player.getDefeatedMonsters(),
            ""
        ));
        tablePrinter.print(headers, rows);
    }

    public void printHelp() {
        System.out.println("""
                        Available commands:
                        - stats : View your current stats
                        - fight : Find a monster to fight
                        - help : Get this help
                        - exit : Exit game""");
    }

    public void printBattleHelp() {
        System.out.println("""
                        Available commands:
                        - stats : View your current stats
                        - roll : Roll the dice
                        - heal : Use heal potion. Restores 30% from MAXHP
                        - help : Get this help""");
    }

    public void printUnknownCommand() {
        System.out.println("Unknown command");
    }

    public void printExitMessage() {
        System.out.println("See you later!");
    }

    public void battleStart(Player player, Entity monster) {
        System.out.println("You've encountered a monster! Type roll to roll the dice or help to get available commands list");
        System.out.println("Attack modifier: Player - " + AttackModifier.getModifier(player, monster) +
                " | Monster - " + AttackModifier.getModifier(monster, player));
    }

    public void gameOver(Player player) {
        System.out.println("You were slain! Defeated monsters: " + player.getDefeatedMonsters());
        System.out.println();
    }

    public void printSuccessfulHeal(Player player) {
        System.out.println("You drank a healing potion! Heals remain: " + player.getAvailableHeals());
    }

    public void healPotionsAreOut () {
        System.out.println("Heal potions are out!");
    }

    public void mainMenu() {
        System.out.println("Type start to start new adventure or exit to leave the game");
    }
}
