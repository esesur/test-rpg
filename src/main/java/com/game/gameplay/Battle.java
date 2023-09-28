package com.game.gameplay;

import com.game.entity.Entity;
import com.game.entity.Player;
import com.game.interaction.UserInterface;
import com.game.util.*;

public class Battle {
    private UserInterface userInterface;
    private final Player player;
    private final Entity enemy;
    private boolean battle;
    private int lastDamage;

    public Battle(Player player) {
        this.player = player;
        this.enemy = MonsterGenerator.getRandomMonster();
        userInterface = new UserInterface();
        battle = true;
        battle();
    }

    private void battle() {
        userInterface.printBattleStats(player, enemy);
        userInterface.battleStart(player, enemy);

        while (battle) {
            String input = ReadInput.readInput();
            switch (input) {
                case "roll":
                    //player attacks
                    if (attack(player, enemy)) {
                        System.out.printf("You hit the monster by %d damage!\n", lastDamage);
                        if (!enemy.isAlive()) {
                            player.addDefeatedMonster();
                            System.out.println("You've defeated the monster! Total defeated monsters: " + player.getDefeatedMonsters());
                            battle = false;
                            userInterface.welcome();
                            break;
                        }
                    } else {
                        System.out.println("You've missed hit!");
                    }

                    // monster attacks
                    if (attack(enemy, player)) {
                        System.out.printf("Monster hit you by %d damage!\n", lastDamage);
                        if (!player.isAlive()) {
                            System.out.printf("Monster hit you by %d damage!\n", lastDamage);
                            userInterface.gameOver(player);
                            battle = false;
                            break;
                        }
                    } else {
                        System.out.println("Monster missed hit!");
                    }

                    userInterface.printBattleInfo(player, enemy);
                    break;
                case "help":
                    userInterface.printBattleHelp();
                    break;
                case "heal":
                    if (player.heal()) {
                        userInterface.printSuccessfulHeal(player);
                        userInterface.printBattleInfo(player, enemy);
                    } else {
                        userInterface.healPotionsAreOut();
                    }
                    break;
                case "stats":
                    userInterface.printBattleStats(player, enemy);
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    public boolean attack(Entity attacker, Entity victim) {
        int attackModifier = AttackModifier.getModifier(attacker, victim);
        boolean successfulAttack = Dice.roll(attackModifier);

        if (successfulAttack) {
            int attackerDamage = RandomGenerator.generate(attacker.getMinDamage(), attacker.getMaxDamage());
            victim.subtractHealth(attackerDamage);
            lastDamage = attackerDamage;
        }

        return successfulAttack;
    }
}
