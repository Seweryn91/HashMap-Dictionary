import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashMap {

    class KeyValue<K, V> {
        public K key;
        public V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;

        }

        K getKey() {
            return this.key;
        }

        V getValue() {
            return this.value;
        }

        void setKey(K key) {
            this.key = key;
        }

        void setValue(V value) {
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public class HashTable<K, V> {
        private int size = 0;
        private int capacity;
        private List<KeyValue>[] elements;

        public HashTable() { }

        public HashTable(int capacity) {
            this.capacity = capacity;
            this.elements = new LinkedList[this.capacity];
        }


        public V get(K key) {
            int keyIndex = getKeyIndex(key);
            List<KeyValue> entries = elements[keyIndex];

            for (KeyValue kv : entries) {
                if (kv.getKey().equals(key)) {
                    return (V) kv.getValue();
                }
            }
        }

        @SuppressWarnings("SuspiciousMethodCalls")
        public void remove(K key) {
            int keyIndex = getKeyIndex(key);
            List<KeyValue> entries = elements[keyIndex];

            for (KeyValue kv : entries) {
                if (kv.getKey().equals(key)) {
                    entries.remove(key);
                    this.size--;
                }
            }
        }

        public void clearAll() {
            for (int i = 0; i < this.capacity; i++) {
                if (elements[i] != null) {
                    this.size -= elements[i].size();
                    elements[i].clear();
                }
            }
        }

        public int size() { return this.size; }

        public void ensureSpace(int requiredSize) {
            if (requiredSize < 0) {
                throw new IllegalArgumentException("Array cannot be resized to negative value");
            }
            if (requiredSize > this.capacity) {
                int newCapacity = (this.capacity*2);
                this.elements = Arrays.copyOf(elements, newCapacity);
            }
        }

        private int getKeyIndex(K key) {
            return key.hashCode() % capacity;
        }
    }
}
