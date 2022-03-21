import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberGenerater {
    int amountOfElements;

    public RandomNumberGenerater(int amountOfElements) {
        this.amountOfElements = amountOfElements;
    }

    public ArrayList<Integer> listOfRandomNumbers(){
        ArrayList<Integer> list= new ArrayList<>();
        for (int i = 1; i<=amountOfElements; i++){
            list.add(i + (int)(Math.random()*1000));
        }
        Collections.shuffle(list);
        return list;
    }
}
