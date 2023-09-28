package com.game.util;

public class Dice {
    private static boolean successfulAttack = false;

    public static boolean roll(int attackModifier) {
        for (int i = 0; i < attackModifier; ++i) {
            int result = RandomGenerator.generate(1, 6);
            if (result == 5 || result == 6) {
                successfulAttack = true;
                break;
            }
        }
        return successfulAttack;
    }
}
