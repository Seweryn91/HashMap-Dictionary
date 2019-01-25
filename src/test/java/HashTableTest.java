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

    @Test
    @DisplayName("Test get with String-Integer pair")
    void testGet() {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("Five", 5);
        table.add("Six", 6);
        table.add("Seven", 7);
        assertEquals((Integer) 6, table.get("Six"));
    }

    @Test
    @DisplayName("Test clear all")
    void testClearAll() {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("One", 1);
        table.add("Two", 2);
        table.add("Three", 3);
        table.clearAll();
        assertEquals(0, table.size());
    }

    @Test
    @DisplayName("Test get with String-String pair")
    void testGet_TypeString() {
        HashTable<String, String> table = new HashTable<>();
        table.add("Ala", "ma Asa");
        table.add("Sierotka", "ma Rysia");
        assertEquals("ma Rysia", table.get("Sierotka"));
    }

    @Test
    @DisplayName("Test add with repeated keys")
    void testAdd_repeatedKeys() {
        HashTable<String, Integer> table = new HashTable<>();
        table.add("One", 1);
        table.add("One", 2);
        table.add("One", 3);
        assertEquals(1, table.size());
    }

}