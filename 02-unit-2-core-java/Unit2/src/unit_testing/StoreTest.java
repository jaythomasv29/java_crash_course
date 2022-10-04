package unit_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store;
    Movie m1;
    Movie m2;
    // Run before each test
    // Used to initialize variables of new objects or whatever you want to use for testing

    @BeforeEach
    public void setup() {
        store = new Store();
        m1 = new Movie("Rugrats", "DVD", 7.0);
        m2 = new Movie("The God Father", "DVD", 7.0);
        store.addMovie(m1);
        store.addMovie(m2);
//        store.addMovie(m1);
//        store.addMovie(new Movie("Rugrats", "DVD", 7.0));
    }

    // Test if the store contains the movie after its added to the collection.
    @Test
    public void movieAdded() {
//        store.addMovie(new Movie("Rugrats", "DVD", 7.0));
        assertTrue(store.contains(new Movie("Rugrats", "DVD", 7.0)));
    }

    @Test
    public void sellMovieTest() {
        store.sellMovie("Rugrats");
        assertFalse((store.contains(m1)));
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("The God Father");
        assertFalse(store.getMovie(1).isAvailable());
    }

    @Test
    public void movieNotInStock() {
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
            store.rentMovie("The God Father");
            store.sellMovie("The God Father");
        });
        assertEquals("Cannot sell, movie is 0currently rented out", thrown.getMessage());
    }
}