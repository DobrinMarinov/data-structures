package structure.hashtable;

public class BasicHashTable<K, V> {

    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    //O(1)
    public V get(K key) {
        int hash = calculateHash(key);

        if(data[hash] == null) {
            return null;
        } else {
            return (V)data[hash].getValue();
        }
    }

    //O(1)
    public void put(K key, V value) {
        int hash = calculateHash(key);

        data[hash] = new HashEntry(key, value);
        size++;
    }

    //here rehashing is performed so O notation could go from linear to quadratic
    public V delete(K key) {
        V value = get(key);

        //clear out the hashtable slot for the key and return removed value
        if(value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
            hash = applyHashAlgorithm(hash);

            //if the next slot is not empty it should be re-added to keep hash algorithm clean
            while (data[hash] != null) {
                HashEntry entry = data[hash];
                data[hash] = null;
                put((K)entry.getKey(), (V)entry.getValue());
                //the hash item is repositioned and didn't really added new one so back off the size
                size--;
                hash = applyHashAlgorithm(hash);
            }
        }
        return value;
    }

    //O(1) close to linear depending how well hash function calculation performs
    public boolean hasKey(K key) {
        int hash = calculateHash(key);
        if(data[hash] == null) {
            return false;
        } else {
            if (data[hash].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    //O(n)
    public boolean hasValue(V value) {
        for (int i = 0; i < this.capacity; i++) {
            HashEntry entry = data[i];
            if(entry != null && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    private int calculateHash(K key) {
        int hash = key.hashCode() % this.capacity;

        //this is done to deal with collisions
        while (data[hash] != null && !data[hash].getKey().equals(key)) {
//            hash = (hash + 1) % this.capacity;
            hash = applyHashAlgorithm(hash);
        }
        return hash;
    }

    private int applyHashAlgorithm(int hash) {
        return (hash + 1) % this.capacity;
    }

    private class HashEntry<K, V> {
        private K key;
        private V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
