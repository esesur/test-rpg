package com.game.entity;

import com.game.entity.config.EntityLimits;

public abstract class Entity {
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;
    private int minDamage;
    private int maxDamage;

    public Entity(int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        setAttack(attack);
        setDefense(defense);
        setMaxHealth(maxHealth);
        setDamage(minDamage, maxDamage);
    }

    public final void setAttack(int attack) {
        if (attack < 1) {
            this.attack = 1;
        } else if (attack > EntityLimits.MAX_ATTACK.value()) {
            this.attack = EntityLimits.MAX_ATTACK.value();
        } else {
            this.attack = attack;
        }
    }

    public final void setDefense(int defense) {
        if (defense < 1) {
            this.defense = 1;
        } else if (defense > EntityLimits.MAX_DEFENSE.value()) {
            this.defense = EntityLimits.MAX_DEFENSE.value();
        } else {
            this.defense = defense;
        }
    }

    public final void setMaxHealth(int maxHealth) {
        if (maxHealth > 0) {
            this.maxHealth = maxHealth;
            resetHealth();
        } else {
            throw new IllegalArgumentException("Health value must be greater than 0");
        }
    }

    public final void setDamage(int minDamage, int maxDamage) {
        if (minDamage > maxDamage) {
            throw new IllegalArgumentException("Minimum damage must be lower than maximum damage");
        } else if (minDamage < 1) {
            throw new IllegalArgumentException("Damage must be greater than 0");
        } else  {
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        }
    }

    public void resetHealth() {
        health = maxHealth;
    }

    public void subtractHealth(int damage) {
        if (damage > health) {
            health = 0;
        } else if (isAlive()) {
            health -= damage;
        }
    }

    public void addHealth(int health) {
        this.health += health;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
