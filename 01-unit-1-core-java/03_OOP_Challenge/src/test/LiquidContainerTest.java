package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidContainerTest {
// JUnit 5 Resource Setup: https://www.youtube.com/watch?v=o5pE7L2tVV8
    @Test
    void getLiquidType() {
        LiquidContainer c = new LiquidContainer("Milk", 85.0);
        assertEquals("Milk", c.getLiquidType());
    }
    @Test
    void getPercentageFull() {
        LiquidContainer c = new LiquidContainer("Milk", 85.0);
        assertEquals(85.0, c.getPercentFull(), 0.001);
    }
}