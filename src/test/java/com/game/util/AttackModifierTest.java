package com.game.util;

import com.game.entity.Monster;
import com.game.entity.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackModifierTest {
    Player player;
    Monster monster;
    @Test
    void getModifierTest() {
        player = new Player(25, 1, 1,  1, 1);
        monster = new Monster(1, 30, 1,  1, 1);
        assertEquals(1, AttackModifier.getModifier(player, monster));

        monster = new Monster(1, 20, 1,  1, 1);
        assertEquals(6, AttackModifier.getModifier(player, monster));

        player = new Player(20, 1, 1,  1, 1);
        monster = new Monster(1, 4, 1,  1, 1);
        assertEquals(17, AttackModifier.getModifier(player, monster));
    }
}
