package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_MultipleTest() {
        // Arrange
        TorpedoStore store = new TorpedoStore(10);

        // Act
        boolean result = store.fire(4);

        // Assert
        assertEquals(true, result);
        assertEquals(6, store.getTorpedoCount());
    }

    @Test
    void fire_FailureRateTest() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void fire_NotEnoughTopedosTest() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    }

    @Test
    void isEmptyTest() {
        // Arrange
        TorpedoStore store1 = new TorpedoStore(1);
        TorpedoStore store2 = new TorpedoStore(0);

        // Assert
        assertEquals(false, store1.isEmpty());
        assertEquals(true, store2.isEmpty());
    }
}
