package com.game.entity;

public class Player extends Entity {
    private int healsAvailable = 4;
    private int defeatedMonsters = 0;

    public Player(int attack, int defense, int health, int minDamage, int maxDamage) {
        super(attack, defense, health, minDamage, maxDamage);
    }

    public boolean heal() {
        if (isAlive() && healsAvailable > 0) {
            addHealth(((int) (getMaxHealth() * 0.3)));
            --healsAvailable;
            if (getHealth() > getMaxHealth()) {
                resetHealth();
            }
            return true;
        }
        return false;
    }

    public int getAvailableHeals() {
        return healsAvailable;
    }

    public void addDefeatedMonster() {
        ++defeatedMonsters;
    }

    public int getDefeatedMonsters() {
        return this.defeatedMonsters;
    }
}
