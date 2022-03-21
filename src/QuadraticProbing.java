public class QuadraticProbing extends OpenAddressingHashTable{

    public QuadraticProbing(int hashTableSize) {
        super(hashTableSize);
    }

    @Override
    protected int hashing(int data) {
        int hash = data % tableSize;
        int quad = 1;
        while (hashTable[hash] != 0 && quad < tableSize){
            collision++;
            hash = (hash + (quad+quad*quad)/2) % tableSize;
            quad++;
            if (hash<0){
                hash += tableSize;
            }
        }
        return hash;
    }
}
