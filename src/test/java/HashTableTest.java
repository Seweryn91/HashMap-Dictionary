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

}