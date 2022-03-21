public class LinearProbing extends OpenAddressingHashTable{

    public LinearProbing(int hashTableSize) {
        super(hashTableSize);
    }

    @Override
    protected int hashing(int data){
        int hash = data % tableSize;
        while (hashTable[hash] != 0){
            collision++;
            hash = (hash+1) % tableSize;
            if (hash<0){
                hash += tableSize;
            }
        }
        return hash;
    }

}
