import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    @DisplayName("Test add")
    void testAdd() {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("Five", 5);
        assertEquals(1, table.size());
    }

    @Test
    @DisplayName("Test remove")
    void testRemove() {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("Five", 5);
        table.add("Six", 6);
        assertEquals(2, table.size());
        table.remove("Five");
        assertEquals(1, table.size());
    }

}