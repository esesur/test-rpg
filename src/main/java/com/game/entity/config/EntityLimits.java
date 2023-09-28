package com.game.entity.config;

public enum EntityLimits {
    MAX_ATTACK(30),
    MAX_DEFENSE(30);

    private final int value;

    private EntityLimits(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
