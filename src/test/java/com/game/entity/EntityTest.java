package com.game.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.game.entity.config.EntityLimits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityTest {
    Entity entity;

    @BeforeEach
    void setUp() {
        entity = new Player(1, 1, 1,  1, 1);
    }

    @Test
    void setAttackTest() {
        entity.setAttack(-1);
        assertEquals(1, entity.getAttack());

        entity.setAttack(0);
        assertEquals(1, entity.getAttack());

        entity.setAttack(EntityLimits.MAX_ATTACK.value() + 1);
        assertEquals(EntityLimits.MAX_ATTACK.value(), entity.getAttack());
    }

    @Test
    void setDefenseTest() {
        entity.setDefense(-1);
        assertEquals(1, entity.getDefense());

        entity.setDefense(0);
        assertEquals(1, entity.getDefense());

        entity.setDefense(EntityLimits.MAX_DEFENSE.value() + 1);
        assertEquals(EntityLimits.MAX_DEFENSE.value(), entity.getDefense());
    }

    @Test
    void setMaxHealthTest() {
        entity.setMaxHealth(100);
        assertEquals(100, entity.getMaxHealth());
        assertEquals(100, entity.getHealth());

        assertThrows(IllegalArgumentException.class, () -> entity.setMaxHealth(-1));
    }

    @Test
    void setDamageTest() {
        Exception exception;

        exception = assertThrows(IllegalArgumentException.class, () -> entity.setDamage(2, 1));
        assertEquals("Minimum damage must be lower than maximum damage", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> entity.setDamage(-1, 1));
        assertEquals("Damage must be greater than 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> entity.setDamage(-1, -1));
        assertEquals("Damage must be greater than 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> entity.setDamage(-1, -2));
        assertEquals("Minimum damage must be lower than maximum damage", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> entity.setDamage(1, -2));
        assertEquals("Minimum damage must be lower than maximum damage", exception.getMessage());
    }

    @Test
    void subtractHealthTest() {
        entity.subtractHealth(2);
        assertEquals(0, entity.getHealth());

        setUp();
        entity.subtractHealth(1);
        assertEquals(0, entity.getHealth());
    }

    @Test
    void addHealthTest() {
        entity.addHealth(1);
        assertEquals(1, entity.getHealth());

        setUp();
        entity.addHealth(entity.getMaxHealth() + 1);
        assertEquals(entity.getMaxHealth(), entity.getHealth());
    }
}
