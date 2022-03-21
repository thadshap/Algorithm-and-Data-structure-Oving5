public abstract class OpenAddressingHashTable {
    int[] hashTable;
    int size, collision;
    int tableSize;

    public OpenAddressingHashTable(int hashTableSize) {
        this.tableSize = hashTableSize;
        hashTable = new int[hashTableSize];
        size = 0;
    }

    protected abstract int hashing(int data);

    public void add(int data) {
        size++;
        if (size <= tableSize) {
            int position = hashing(data);
            hashTable[position] = data;
        }else {
            System.out.println("Kan ikke legges inn på grunn av tabellen er full");
        }
    }

    public int getSize() {
        return size;
    }

    public int getTableSize() {
        return tableSize;
    }

    public int getCollision() {
        return collision;
    }
}
