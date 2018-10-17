package by.bsu.hashtable.linearcollizion.entity;

public class HashTable {
    private final static int HASH_DIGIT = 113;
    private Unit[] hashTable;

    public HashTable() {
        hashTable = new Unit[HASH_DIGIT];
    }

    public void add(long value) {
        int key = (int) (value % HASH_DIGIT);

        if (hashTable[key] == null) {
            hashTable[key] = new Unit(key);
            hashTable[key].getValues().add(value);
        } else {
            hashTable[key].getValues().add(value);
        }
    }

    public boolean remove(long value) {
        Unit elem;
        for (int i = 0; i < hashTable.length; ++i) {
            elem = hashTable[i];
            if (elem != null && hashTable[i].getValues().contains(value)) {
                elem.getValues().remove(elem.getValues().indexOf(value));
                if (elem.getValues().isEmpty()) {
                    hashTable[i] = null;
                }
                return true;
            }
        }
        return false;
    }

    public Integer find(long value) {
        for (Unit elem : hashTable) {
            if (elem != null && elem.getValues().contains(value)) {
                return elem.getKey();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Unit elem : hashTable) {
            if (elem != null) {
                string.append(elem.getKey());
                string.append(":").append(elem.getValues().toString()).append("\n");
            }
        }
        return string.toString();
    }
}
