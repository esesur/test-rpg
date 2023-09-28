package com.game.util;

import com.game.entity.config.EntityLimits;
import com.game.entity.Entity;
import com.game.entity.Monster;

public class MonsterGenerator {
    public static Entity getRandomMonster() {
        int maxDamage = 99;
        int minDamage = RandomGenerator.generate(1, maxDamage);

        return new Monster(
                RandomGenerator.generate(1, EntityLimits.MAX_ATTACK.value()),
                RandomGenerator.generate(1, EntityLimits.MAX_DEFENSE.value()),
                RandomGenerator.generate(1, 100), // health
                minDamage,
                RandomGenerator.generate(minDamage, maxDamage) // max damage
        );
    }
}
