import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    class HashTable<K, V> {
        private int size = 0;
        private int capacity;
        private List<KeyValue>[] elements;

        public HashTable() {
            this(10);
        }

        public HashTable(int capacity) {
            this.capacity = capacity;
            this.elements = new LinkedList[this.capacity];
        }

        public void add(K key, V value) {
            ensureSpace(this.size+1);
            int keyIndex = getKeyIndex(key);

            if (elements[keyIndex] == null) {
                elements[keyIndex] = new LinkedList<KeyValue>();
            }

            List<KeyValue> linkedList = elements[keyIndex];

            for (KeyValue kv: linkedList) {
                if (kv.getKey().equals(key)) {
                    kv.setValue(value);
                    return;
                }
            }

            linkedList.add(new KeyValue(key, value));
            this.size++;
        }


        public V get(K key) {
            int keyIndex = getKeyIndex(key);
            List<KeyValue> entries = elements[keyIndex];

            for (KeyValue kv : entries) {
                if (kv.getKey().equals(key)) {
                        return (V) kv.getValue();
                }
            }
            return null;
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
