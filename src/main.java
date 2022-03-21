import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        ChainingHashTable hashTable = new ChainingHashTable(130);
        ReadFile readFile = new ReadFile("http://www.iie.ntnu.no/fag/_alg/hash/navn.txt");
        BufferedReader reader = readFile.reader();

        // Populating list
        String inputLine;
        while ((inputLine = reader.readLine()) != null) list.add(inputLine);
            //System.out.println(list.toString() + "\n" + list.size());

        // Adding elements from list to hashTable
        System.out.println("Innsetting starter...");
        for (int i = 0; i<list.size()-1; i++) hashTable.insert(list.get(i));
        if (hashTable.getCollision() == 0) System.out.println("Ingen kollisjoner ved innsetting");
        //hashTable.printHashTable();
        System.out.println("--------------------------------------------------------------------");

        // Searching for an element
        System.out.println("Søking starter...");
        String name ="Thadshajini Paramsothy";
        if (!hashTable.search(name)) System.out.print("Fant ikke navnet " + name);

        System.out.println("\n--------------------------------------------------------------------");

        // Calculations
        int m = hashTable.getMaxSize();
        int n = hashTable.getSize();
        int collisionCount = hashTable.getCollision();
        double loadFactor = (double)n/m;
        double average = (double) collisionCount/n;
        System.out.println("Gjennomsnittlig antall kollisjoner per person er " + average);
        System.out.println("Lastfaktoren er " + loadFactor);

        reader.close();

        System.out.println("--------------------------------------------------------------------");

        int numberOfElements = 10_000_019;
        int fifty = (int) (numberOfElements*0.5);
        int eighty = (int) (numberOfElements*0.8);
        int ninety = (int) (numberOfElements*0.9);
        int ninety_nine = (int) (numberOfElements*0.99);

        RandomNumberGenerater randomNumbersFifty = new RandomNumberGenerater(fifty);
        RandomNumberGenerater randomNumbersEighty = new RandomNumberGenerater(eighty);
        RandomNumberGenerater randomNumbersNinety = new RandomNumberGenerater(ninety);
        RandomNumberGenerater randomNumbersNinety_nine = new RandomNumberGenerater(ninety_nine);
        RandomNumberGenerater randomNumbersHundred = new RandomNumberGenerater(numberOfElements);

        ArrayList<Integer> arrayFifty = randomNumbersFifty.listOfRandomNumbers();
        ArrayList<Integer> arrayEighty = randomNumbersEighty.listOfRandomNumbers();
        ArrayList<Integer> arrayNinety = randomNumbersNinety.listOfRandomNumbers();
        ArrayList<Integer> arrayNinety_nine = randomNumbersNinety_nine.listOfRandomNumbers();
        ArrayList<Integer> arrayHundred = randomNumbersHundred.listOfRandomNumbers();

        System.out.println("Linear probing : \n");

        System.out.println("Elementer utfyller 50% av hash tabellen");
        linearProbingAnalysis(numberOfElements,arrayFifty);

        System.out.println("Elementer utfyller 80% av hash tabellen");
        linearProbingAnalysis(numberOfElements,arrayEighty);

        System.out.println("Elementer utfyller 90% av hash tabellen");
        linearProbingAnalysis(numberOfElements,arrayNinety);

        System.out.println("Elementer utfyller 99% av hash tabellen");
        linearProbingAnalysis(numberOfElements,arrayNinety_nine);

        System.out.println("Elementer utfyller 100% av hash tabellen");
        linearProbingAnalysis(numberOfElements,arrayHundred);

        System.out.println("\n-----------------------------------------------------------------------------------\n");

        System.out.println("Quadratic probing : \n");

        System.out.println("Elementer utfyller 50% av hash tabellen");
        quadraticProbingAnalysis(numberOfElements,arrayFifty);

        System.out.println("Elementer utfyller 80% av hash tabellen");
        quadraticProbingAnalysis(numberOfElements,arrayEighty);

        System.out.println("Elementer utfyller 90% av hash tabellen");
        quadraticProbingAnalysis(numberOfElements,arrayNinety);

        System.out.println("Elementer utfyller 99% av hash tabellen");
        quadraticProbingAnalysis(numberOfElements,arrayNinety_nine);

        System.out.println("Elementer utfyller 100% av hash tabellen");
        quadraticProbingAnalysis(numberOfElements,arrayHundred);


        System.out.println("\n-----------------------------------------------------------------------------------\n");

        System.out.println("Double hashing : \n");

        System.out.println("Elementer utfyller 50% av hash tabellen");
        doubleHashingAnalysis(numberOfElements,arrayFifty);

        System.out.println("Elementer utfyller 80% av hash tabellen");
        doubleHashingAnalysis(numberOfElements,arrayEighty);

        System.out.println("Elementer utfyller 90% av hash tabellen");
        doubleHashingAnalysis(numberOfElements,arrayNinety);

        System.out.println("Elementer utfyller 99% av hash tabellen");
        doubleHashingAnalysis(numberOfElements,arrayNinety_nine);

        System.out.println("Elementer utfyller 100% av hash tabellen");
        doubleHashingAnalysis(numberOfElements,arrayHundred);

 }

 public static LinearProbing linearProbing(int numberOfElements, ArrayList<Integer> array){
      LinearProbing linearProbing = new LinearProbing(numberOfElements);
      for (int i = 0; i < array.size(); i++) {
          linearProbing.add(array.get(i));
      }
      return linearProbing;
 }

 public static void linearProbingAnalysis(int numberOfElements, ArrayList<Integer> array){
     Date start = new Date();
     int round = 0;
     double time;
     Date end;
     LinearProbing linearProbing;
     do{
         linearProbing = linearProbing(numberOfElements,array);
         end = new Date();
         round++;
     }while (end.getTime()-start.getTime()<1000);
     time = (double) (end.getTime()-start.getTime())/round;
     System.out.println("Millisekunder pr. runde: " + time);

     int linearProbingMaxSize = linearProbing.getTableSize();
     int linearProbingSize = linearProbing.getSize();
     double linearProbingLastfactor = (double)linearProbingSize/linearProbingMaxSize;
     System.out.println("Lastfaktoren: " + linearProbingLastfactor );
     System.out.println("Kollisjoner: " + linearProbing.getCollision()+"\n");
 }

 public static QuadraticProbing quadraticProbing(int numberOfElements, ArrayList<Integer> array){
      QuadraticProbing quadraticProbing = new QuadraticProbing(numberOfElements);
      for (int i = 0; i < array.size(); i++) {
          quadraticProbing.add(array.get(i));
      }
      return quadraticProbing;
 }

 public static void quadraticProbingAnalysis(int numberOfElements, ArrayList<Integer> array){
       Date start = new Date();
       int round = 0;
       double time;
       Date end;
       QuadraticProbing quadraticProbing;
       do{
           quadraticProbing = quadraticProbing(numberOfElements,array);
           end = new Date();
           round++;
       }while (end.getTime()-start.getTime()<1000);
       time = (double) (end.getTime()-start.getTime())/round;
       System.out.println("Millisekunder pr. runde: " + time);

       int quadraticProbingMaxSize = quadraticProbing.getTableSize();
       int quadraticProbingSize = quadraticProbing.getSize();
       double quadraticProbingLastfactor = (double)quadraticProbingSize/quadraticProbingMaxSize;
       System.out.println("Lastfaktoren: " + quadraticProbingLastfactor);
       System.out.println("Kollisjoner: " + quadraticProbing.getCollision() + "\n");
 }

 public static DobbelHashing doubleHashing(int numberOfElements, ArrayList<Integer> array){
     DobbelHashing dobbelHashing = new DobbelHashing(numberOfElements);
     for (int i = 0; i<array.size(); i++){
         dobbelHashing.add(array.get(i));
     }
    return dobbelHashing;
 }
 public static void doubleHashingAnalysis(int numberOfElements, ArrayList<Integer> array) {
      Date start = new Date();
      int round = 0;
      double time;
      Date end;
      DobbelHashing dobbelHashing;
      do{
          dobbelHashing = doubleHashing(numberOfElements,array);
          end = new Date();
          round++;
      }while (end.getTime()-start.getTime()<1000);
      time = (double) (end.getTime()-start.getTime())/round;
      System.out.println("Millisekunder pr. runde: " + time);

      int doubleHashingMaxSize = dobbelHashing.getTableSize();
      int doubleHashingSize = dobbelHashing.getSize();
      double doubleHashingLastfactor = (double)doubleHashingSize/doubleHashingMaxSize;
      System.out.println("Lastfaktoren: " + doubleHashingLastfactor);
      System.out.println("Kollisjoner: " + dobbelHashing.getCollision() + "\n");
 }
}
