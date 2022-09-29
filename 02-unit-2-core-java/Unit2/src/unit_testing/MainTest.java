package unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void subtotalIsValid() {
        assertEquals(20 , Main.getSubtotalAmount());
    }

    // Unit test tax field
    @Test
    public void taxIsValid() {
        assertEquals(3.9, Main.getTax(30));
    }

    @Test //Total equals subtotal
    public void totalIsValid() {
        assertEquals(33.9, Main.getTotal(30));
    }
}