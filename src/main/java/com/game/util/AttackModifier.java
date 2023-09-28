package com.game.util;

import com.game.entity.Entity;

public class AttackModifier {
    public static int getModifier(Entity attacker, Entity victim) {
        int attackModifier = attacker.getAttack() - victim.getDefense() + 1;
        return (attackModifier <= 0) ? 1 : attackModifier;
    }
}
