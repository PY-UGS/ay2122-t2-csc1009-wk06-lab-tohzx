import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Integer> hash= new HashMap<>() {{
            put(0,1);
            put(1,3);
            put(2,5);
            put(3,7);
            put(4,9);
            put(5,11);
        }};

        System.out.println("Q4: Before Change: " + hash.toString());
        hash = addAndSort(hash, 8);
        System.out.println("Q4: After Change: " + hash.toString());

        HashMap<Integer, Integer> hash2= new HashMap<>() {{
            put(0,1);
            put(1,3);
            put(2,5);
            put(3,7);
            put(4,9);
            put(5,11);
        }};
        System.out.println("Q5: Before Change: " + hash2.toString());
        hash = swapValues(hash2, 0, 4);
        System.out.println("Q5: After Change: " + hash2.toString());

        HashMap<Integer, Integer> randomHash= new HashMap<>();
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
            randomHash.put(i, randomNum);
        }
        int randomSearchVal = rand.nextInt((9999 - 1000) + 1) + 1000;
        int position = findValue(randomHash, randomSearchVal);
        System.out.println("Q6: Position = " + position);
    }

    public static HashMap<Integer, Integer> addAndSort(HashMap<Integer, Integer> hash, int newValue) {
        int tempValue = -1;
        boolean added = false;
        for(int i = 0; i < hash.size()+1; i++) {
            if(added) {
                if(i == hash.size()) {
                    hash.put(i, tempValue);
                    break;
                } else {
                    int tempValue2 = hash.get(i);
                    hash.replace(i, tempValue);
                    tempValue = tempValue2;
                }
            }
            else if(newValue < hash.get(i)) {
                tempValue = hash.get(i);
                added = true;
                hash.replace(i, newValue);
            }
        }
        return hash;
    }

    public static HashMap<Integer, Integer> swapValues(HashMap<Integer, Integer> hash2, int indexOne, int indexTwo) {
        int element1 = hash2.get(indexOne);
        int element2 = hash2.get(indexTwo);

        hash2.replace(indexOne, element2);
        hash2.replace(indexTwo, element1);
        return hash2;
    }

    public static int findValue(HashMap<Integer, Integer> hash, int searchVal) {
        for (int i = 0; i < 500; i++) {
            if (hash.get(i) == searchVal) {
                return i;
            }
        }
        return -1;
    }
}

