package com.game.util;

public class RandomGenerator {
    public static int generate(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
