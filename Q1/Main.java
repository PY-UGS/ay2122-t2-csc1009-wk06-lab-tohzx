import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11));

        System.out.println("Q1: Before Change: " + list.toString());
        list = addAndSort(list, 8);
        System.out.println("Q1: After Change: " + list.toString());

        list = new LinkedList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 11));
        System.out.println("Q2: Before Change: " + list.toString());
        list = swapValues(list, 0, 4);
        System.out.println("Q2: After Change: " + list.toString());

        LinkedList randomList = new LinkedList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
            randomList.add(randomNum);
        }
        int randomSearchVal = rand.nextInt((9999 - 1000) + 1) + 1000;
        int position = findValue(randomList, randomSearchVal);
        System.out.println(position);
    }

    public static LinkedList<Integer> addAndSort(LinkedList<Integer> list, int Value) {
        for (int i = 0; i < list.size(); i++) {
            if (Value <= list.get(i)) {
                list.add(i, Value);
                break;
            } else if (Value > list.getLast()) {
                list.add(Value);
                break;
            }
        }
        return list;
    }

    public static LinkedList<Integer> swapValues(LinkedList<Integer> list, int indexOne, int indexTwo) {
        int element1 = list.get(indexOne);
        int element2 = list.get(indexTwo);

        list.set(indexOne, element2);
        list.set(indexTwo, element1);
        return list;
    }

    public static int findValue(LinkedList<Integer> list, int searchVal) {
        for (int i = 0; i < 500; i++) {
            if (list.get(i) == searchVal) {
                return i;
            }
        }
        return -1;
    }
}

