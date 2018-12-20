import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class BattleOfSorts {
    public static void main(String[] args) {
        //get input of user's desired amount of ints in arrays
        int arrayOfInts = introduction();
        System.out.println();

        /*1. Create initial list
          2. Create list duplicates
          3. Call each sort method using each array
          4. Clear ArrayList
          5. Next sort method (repeat 2-4)
          6. Clear initial list
          -Repeat for other list types (Reversed & Random)
        */
        System.out.printf("%26s%n", "---ORDERED LIST---");
        //ORDERED LIST CREATION
        ArrayList<Integer> sortOrdered = new ArrayList<>(arrayOfInts);
        for(int i = 0; i < arrayOfInts; i++){
            sortOrdered.add(i, i);
        }
        ArrayList<Integer> sortOrdered0 = new ArrayList<>(sortOrdered);bubbleSort(sortOrdered0);    sortOrdered0.clear();
        ArrayList<Integer> sortOrdered1 = new ArrayList<>(sortOrdered);cocktailSort(sortOrdered1);  sortOrdered1.clear();
        ArrayList<Integer> sortOrdered2 = new ArrayList<>(sortOrdered);selectionSort(sortOrdered2); sortOrdered2.clear();
        ArrayList<Integer> sortOrdered3 = new ArrayList<>(sortOrdered);insertionSort(sortOrdered3); sortOrdered3.clear();
        ArrayList<Integer> sortOrdered4 = new ArrayList<>(sortOrdered);printMerge(sortOrdered4);    sortOrdered4.clear();
        ArrayList<Integer> sortOrdered5 = new ArrayList<>(sortOrdered);printQuickSort(sortOrdered5);sortOrdered5.clear();
        ArrayList<Integer> sortOrdered6 = new ArrayList<>(sortOrdered);sort(sortOrdered6);          sortOrdered6.clear();
        sortOrdered.clear();
        System.out.println();


        System.out.printf("%27s%n", "---REVERSED LIST---");
        //REVERSED LIST CREATION
        //Create Reversed version of ordered list
        ArrayList<Integer> sortReversed = new ArrayList<>(arrayOfInts);
        for(int i = 0; i < arrayOfInts; i++){
            //array length - 1 - current loop number; eg. 10 - 1 - 5 = 4
            sortReversed.add(i, (arrayOfInts - 1 - i));
        }
        ArrayList<Integer> sortReversed0 = new ArrayList<>(sortReversed);bubbleSort(sortReversed0);    sortReversed0.clear();
        ArrayList<Integer> sortReversed1 = new ArrayList<>(sortReversed);cocktailSort(sortReversed1);  sortReversed1.clear();
        ArrayList<Integer> sortReversed2 = new ArrayList<>(sortReversed);selectionSort(sortReversed2); sortReversed2.clear();
        ArrayList<Integer> sortReversed3 = new ArrayList<>(sortReversed);insertionSort(sortReversed3); sortReversed3.clear();
        ArrayList<Integer> sortReversed4 = new ArrayList<>(sortReversed);printMerge(sortReversed4);    sortReversed4.clear();
        ArrayList<Integer> sortReversed5 = new ArrayList<>(sortReversed);printQuickSort(sortReversed5);sortReversed5.clear();
        ArrayList<Integer> sortReversed6 = new ArrayList<>(sortReversed);sort(sortReversed6);          sortReversed6.clear();
        sortReversed.clear();
        System.out.println();


        System.out.printf("%25s%n", "---RANDOM LIST---");
        //RANDOM LIST CREATION
        //Make Random object, the new array to be sorted, and an ArrayList object that will be modified later
        Random randInt = new Random();
        ArrayList<Integer> sortRandom = new ArrayList<>(arrayOfInts);
        ArrayList<Integer> ints = new ArrayList<>();
        //populate the array w/ a list in numerical order
        for(int i = 0;i < arrayOfInts; i++){
            ints.add(i);
        }
      /*comb through the ordered array list
        replace each index of the array w/ a random number not already in the array list
      */
        for(int i = 0;i < arrayOfInts; i++){
            int j = ints.remove(randInt.nextInt(ints.size()));
            sortRandom.add(i, j);
        }
        ArrayList<Integer> sortRandom0 = new ArrayList<>(sortRandom);bubbleSort(sortRandom0);    sortRandom0.clear();
        ArrayList<Integer> sortRandom1 = new ArrayList<>(sortRandom);cocktailSort(sortRandom1);  sortRandom1.clear();
        ArrayList<Integer> sortRandom2 = new ArrayList<>(sortRandom);selectionSort(sortRandom2); sortRandom2.clear();
        ArrayList<Integer> sortRandom3 = new ArrayList<>(sortRandom);insertionSort(sortRandom3); sortRandom3.clear();
        ArrayList<Integer> sortRandom4 = new ArrayList<>(sortRandom);printMerge(sortRandom4);    sortRandom4.clear();
        ArrayList<Integer> sortRandom5 = new ArrayList<>(sortRandom);printQuickSort(sortRandom5);sortRandom5.clear();
        ArrayList<Integer> sortRandom6 = new ArrayList<>(sortRandom);sort(sortRandom6);          sortRandom6.clear();
        sortRandom.clear();
    }

    //TODO: Implement more sort methods
    public static void bubbleSort(ArrayList<Integer> array){
        //take a pair of ints. Compare them. Swap if needed.
        System.out.print("   BUBBLE SORT: ");

        long startTime = System.currentTimeMillis();
        long swaps = 0;

        //keeps track of already sorted positions in the array for each pass
        for(int i = 0; i < array.size(); i++){
            for(int j = 1; j < array.size() - i; j++){
                if(array.get(j - 1) > array.get(j)){
                    Collections.swap(array, j-1, j);
                    swaps++;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;

        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swaps " + swaps);
    }

    //Cocktail Sort
    public static void cocktailSort(ArrayList<Integer> L){
        /*Cocktail sort, while similar to bubble sort, is slightly faster, thus it is the
        best and fastest implementation of the two*/
        System.out.print(" COCKTAIL SORT: ");

        long startTime = System.currentTimeMillis();
        long swaps = 0;

        boolean swapped;
        do{
            swapped = false;
            for(int i = 0; i < L.size() - 2; i++){
                if(L.get(i) > L.get(i + 1)){
                    Collections.swap(L, i, i+1);
                    swaps++;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
            swapped = false;
            for(int i = L.size() - 2; i > 0; i--){
                if(L.get(i)>L.get(i+1)){
                    Collections.swap(L, i, i+1);
                    swaps++;
                    swapped=true;
                }
            }
        }while (swapped);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;

        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swaps " + swaps);
    }

    //Selection Sort
    public static void selectionSort(ArrayList<Integer> array){
        System.out.print("SELECTION SORT: ");

        long startTime = System.currentTimeMillis();
        long swaps = 0;
        //first find the min. number by combing the array, then swap w/ current index
        //repeat. w/ index place increasing by one until you reach the last key
      /*since the last key will already be the largest in the list, time
          can be saved by excluding it in the for loop*/
        for(int i = 0; i < array.size() - 1; i++){
            //minIndex will be used to keep track of which indexes in the array were already passed through
            int min = array.get(i);
            int minIndex = i;
            for(int j = i + 1; j < array.size(); j++){
                if(min > array.get(j)){
                    min = array.get(j);
                    minIndex = j;
                }
            }
          /*if i and index are not equal, swap array[index] and array[i];
            use a temp to hold array[index] for later declaration in array[i]*/
            if(minIndex != i){
                array.set(minIndex, array.get(i));
                array.set(i, min);
                swaps++;
            }
        }

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;

        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swaps " + swaps);
    }

    //Insertion Sort
    public static void insertionSort(ArrayList<Integer> array){
        System.out.print("INSERTION SORT: ");
        long startTime = System.currentTimeMillis();
        long swaps = 0;

        int j;
        int temp;
        for(int i = 1; i < array.size(); i++){
            temp = array.get(i);
            for(j = i - 1; (j >= 0) && (array.get(j) > temp); j--){
                array.set(j+1, array.get(j));
                swaps++;
            }
            array.set(j+1, temp);
        }

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swaps " + swaps);
    }

    //Radix Sort
    public static void printRadix(ArrayList<Integer> L){
        System.out.print("    RADIX SORT: ");
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting
        printTime(executionTime);
        System.out.println();
    }

    //Merge Sort
    public static void printMerge(ArrayList<Integer> L){
        System.out.print("    MERGE SORT: ");
        long startTime = System.currentTimeMillis();

        mergeSort(L);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting
        printTime(executionTime);
        System.out.println();
    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> L) {
        if (L.size() == 1) {
            return L;
        }
        else {
            //Split L ArrayList
            ArrayList<Integer> a = new ArrayList<>(L.subList(0, L.size() / 2));
            ArrayList<Integer> b = new ArrayList<>(L.subList(L.size() / 2, L.size()));
            ArrayList<Integer> A = mergeSort(a);
            ArrayList<Integer> B = mergeSort(b);
            //merge and sort array lists
            merge(L, A, B);
        }
        return L;
    }
    private static void merge(ArrayList<Integer> L, ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftIdx = 0;
        int rightIdx = 0;
        int newIdx = 0;

        while (leftIdx < left.size() && rightIdx < right.size()) {
            if(left.get(leftIdx).compareTo(right.get(rightIdx)) < 0){
                L.set(newIdx, left.get(leftIdx));
                leftIdx++;
            }
            else{
                L.set(newIdx, right.get(rightIdx));
                rightIdx++;
            }
            newIdx++;
        }
        ArrayList<Integer> remain;
        int remainIdx;
        if (leftIdx >= left.size()) {
            remain = right;
            remainIdx = rightIdx;
        }
        else{
            remain = left;
            remainIdx = leftIdx;
        }
        for(int i=remainIdx; i < remain.size(); i++){
            L.set(newIdx, remain.get(i));
            newIdx++;
        }
    }

    //Quicksort
    public static void printQuickSort(ArrayList<Integer> L){
        System.out.print("    QUICK SORT: ");
        long startTime = System.currentTimeMillis();

        QuickSort q = new QuickSort(L);
        q.quickSort(0, L.size()-1);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting + swaps
        int swaps = q.getSwaps();
        printTime(executionTime);
        System.out.println(" | swaps " + swaps);
    }

    //Java's implementation of QuickSort
    public static void sort(ArrayList<Integer> L){
        System.out.print("     JAVA'S QS: ");
        long startTime = System.currentTimeMillis();

        Collections.sort(L);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting
        printTime(executionTime);
        System.out.println();
    }

    //Asks user for desired num of ints, then returns that int - with input validation
    public static int introduction(){
        Scanner input = new Scanner(System.in);
        int arrayOfInts;

        //confirmation input for when user wants more than 250K elements in each array.
        Scanner verifyBigInt = new Scanner(System.in);
        /*
          -Input number of ints for each list
             -Must be a positive integer above 0
        */
        do {
            System.out.println("WARNING! Arrays w/ 200K+ integers may take an extremely long time to sort!");
            System.out.print("How many integers in the arrays do you want for this test?: ");
            while (!input.hasNextInt()) {
                System.out.print("Must be a positive int! ");
                input.next();
            }
            arrayOfInts = input.nextInt();
        } while (arrayOfInts < 0);

        return arrayOfInts;
    }
    //Convert times; Print as either milliseconds, minutes and/or seconds
    public static void printTime(double time){
        double minutes = (time / 1000) / 60;
        double seconds = (time / 1000) % 60;

        if(time > 60000){
            System.out.printf("%2.0f minute(s) and %6.3f seconds", minutes, seconds);
        }
        else if(time > 1000){
            System.out.printf("%6.3f seconds", seconds);
        }
        else{
            System.out.printf("%4.0f milliseconds", time);
        }
    }
}