public class ChainingHashTable {
    // Declaration of Hash Table
    LinkedList[] hashTable;

    // stores the size of HashTable
    int size,collision;

    // Constructor
    ChainingHashTable(int hashTableSize) {
        // Creating an empty Hash Table
        hashTable = new LinkedList[hashTableSize];
        size = 0;
    }
    /**
     * A hash routine for String objects.
     * @param key the String to hash.
     * @return the hash value.
     */
    private int hash(String key) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++) hashVal = (37+i) * hashVal + key.charAt(i);
        hashVal %= hashTable.length;
        if (hashVal < 0)
            hashVal += hashTable.length;
        return hashVal;
    }

    // Function to insert a value/element
    public void insert(String value) {
        size++;
        // gets the position/index where the value should be
        // stored
        int position = hash(value);

        if (hashTable[position] == null) {
            LinkedList list = new LinkedList();
            list.add(value);
            hashTable[position] = list;
        }else{
            collision++;
            System.out.println(position + " kollideres av " + value);
            hashTable[position].add(value);
        }
    }

    // Search function
    public boolean search (String name){
       boolean found = false;
        for (int i = 0; i < hashTable.length && !found; i++) {
            LinkedList element = hashTable[i];
            if (element != null && element.lookUp(name)) {
                found = true;
                if (element.getSize()>1) {
                    System.out.print(i + ": ");
                    element.printList();
                }
            }
        }
        return found;
    }

    // Function that returns size of the amount of elements added into the Hash Table
    public int getSize() {
        return size;
    }

    // Function that returns size of the amount of collision
    public int getCollision() {
        return collision;
    }

    // Function that returns size of Hash Table
    public  int getMaxSize(){
        return hashTable.length;
    }

    // Function to print hash table
    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print("At " + i + ":  ");

            LinkedList element = hashTable[i];

            if (element != null) {
                element.printList();
            }
            System.out.println();
        }
    }
}
