public class DobbelHashing extends OpenAddressingHashTable{
    public DobbelHashing(int hashTableSize) {
        super(hashTableSize);
    }

    @Override
    protected int hashing(int data) {
       int h1 = myHash1(data);
       int h2 = myHash2(data);
       int i = 1;
       while (hashTable[h1] != 0){
           collision++;
           h1 += (h2 + (i+i*i)/2);
           h1 %= tableSize;
           i++;
           if (h1<0){
               h1 += tableSize;
           }
       }
       return h1;
    }

    private int myHash1(int data){
        int h1 = data % tableSize;
        if (h1<0){
            h1 += tableSize;
        }
        return h1;
    }

    private int myHash2(int data){
        int h2 = tableSize-(data%tableSize)*tableSize;
        if (h2<0){
            h2 += tableSize;
        }
        return h2;
    }
}
