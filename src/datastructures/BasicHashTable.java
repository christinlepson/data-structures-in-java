package datastructures;

public class BasicHashTable<X,Y> {

    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public Y get(X key) {
        int hash = calculateHashSlot(key);
        if (data[hash] == null) {
            return null;
        }
        return (Y) data[hash].getValue();
    }

    public void put(X key, Y value) {
        int hashSlot = calculateHashSlot(key);
        data[hashSlot] = new HashEntry<>(key, value);
        size++;
    }

    public int size() {
        return size;
    }

    private int calculateHashSlot(X key) {
        int hashSlot = (key.hashCode() % this.capacity);
        while(data[hashSlot] != null && !data[hashSlot].getKey().equals(key)) {
            hashSlot = (hashSlot + 1) % this.capacity;
        }
        return hashSlot;
    }

    private class HashEntry<X,Y> {

        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }

    }

}
