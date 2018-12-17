import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BattleOfSorts {
    public static void main(String[] args) {
        //get input of user's desired amount of ints in arrays
        Scanner input = new Scanner(System.in);
        int arrayOfInts;

        //confirmation input for when user wants more than 250K elements in each array.
        Scanner verifyBigInt = new Scanner(System.in);

        /*
          -Input number of ints for each list
             -Must be a positive integer above 0
        */
        do {
            System.out.print("How many integers in the arrays do you want for this test?: ");
            while (!input.hasNextInt()) {
                System.out.print("Must be positive int!: ");
                input.next();
            }
            arrayOfInts = input.nextInt();

          //for arrays of over 250K; confirm from user
            if (arrayOfInts >= 250000) {
                boolean yn;
                System.out.println("Arrays w/ 250K or more elements may take an extremely long time depending on machine!");
                System.out.print("Do you still want to continue? y/n: ");
                do{
                    switch (verifyBigInt.next().toLowerCase()) {
                        case "y":
                            yn = true;
                            break;
                        case "n":
                            System.out.print("New integers amount: ");
                            arrayOfInts = input.nextInt();
                            yn = true;
                            break;
                        default:
                            System.out.print("y/n?: ");
                            yn = false;
                            break;
                    }
                }while(!yn);
            }
        } while (arrayOfInts < 0);
        System.out.println();

        //ORDERED LIST
        ArrayList<Integer> sortOrdered = new ArrayList<>(arrayOfInts);
        for(int i = 0; i < arrayOfInts; i++){
            sortOrdered.add(i, i);
        }

        //REVERSED LIST
        //Create Reversed version of ordered list
        ArrayList<Integer> sortReversed = new ArrayList<>(arrayOfInts);
        for(int i = 0; i < arrayOfInts; i++){
            //array length - 1 - current loop number; eg. 10 - 1 - 5 = 4
            sortReversed.add(i, (arrayOfInts - 1 - i));
        }

        //RANDOM LIST
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

        //LIST CLONES
        /*make 3 extra clones of each array since each will be sorted once sort method is finished
          Clear the lists after the test is finished to conserve memory for slower machines
          (though difference may be negligible, it's better safe than sorry)
        */
        ArrayList<Integer> sortOrdered1 = new ArrayList<>(sortOrdered);
        ArrayList<Integer> sortOrdered2 = new ArrayList<>(sortOrdered);
        ArrayList<Integer> sortOrdered3 = new ArrayList<>(sortOrdered);
        //ArrayList<Integer> sortOrdered4 = new ArrayList<>(sortOrdered);
        ArrayList<Integer> sortOrdered5 = new ArrayList<>(sortOrdered);

        //Call each sort method using each array
        //Ordered sort
        System.out.printf("%26s%n", "---ORDERED LIST---");
        bubbleSort(sortOrdered);
        selectionSort(sortOrdered1);
        insertionSort(sortOrdered2);
        printMerge(sortOrdered3);
        //radixSort
        printQuickSort(sortOrdered5);

        //clear ArrayLists
        sortOrdered1.clear();
        sortOrdered2.clear();
        sortOrdered3.clear();
        //sortOrdered4.clear();
        sortOrdered5.clear();
        System.out.println();


        //Reversed sort
        ArrayList<Integer> sortReversed1 = new ArrayList<>(sortReversed);
        ArrayList<Integer> sortReversed2 = new ArrayList<>(sortReversed);
        ArrayList<Integer> sortReversed3 = new ArrayList<>(sortReversed);
        //ArrayList<Integer> sortReversed4 = new ArrayList<>(sortReversed);
        ArrayList<Integer> sortReversed5 = new ArrayList<>(sortReversed);
        System.out.printf("%27s%n", "---REVERSED LIST---");
        bubbleSort(sortReversed);
        selectionSort(sortReversed1);
        insertionSort(sortReversed2);
        printMerge(sortReversed3);
        //radixSort
        System.out.println(sortReversed5);
        printQuickSort(sortOrdered5);
        System.out.println(sortReversed5);

        //clear ArrayLists
        sortReversed1.clear();
        sortReversed2.clear();
        sortReversed3.clear();
        //sortReversed4.clear();
        sortReversed5.clear();
        System.out.println();


        ArrayList<Integer> sortRandom1 = new ArrayList<>(sortReversed);
        ArrayList<Integer> sortRandom2 = new ArrayList<>(sortReversed);
        ArrayList<Integer> sortRandom3 = new ArrayList<>(sortReversed);
        //ArrayList<Integer> sortRandom4 = new ArrayList<>(sortReversed);
        ArrayList<Integer> sortRandom5 = new ArrayList<>(sortReversed);
        //Random sort
        System.out.printf("%25s%n", "---RANDOM LIST---");
        bubbleSort(sortRandom);
        selectionSort(sortRandom1);
        insertionSort(sortRandom2);
        printMerge(sortRandom3);
        //radixSort
        printQuickSort(sortRandom5);
        sortRandom1.clear();
        sortRandom2.clear();
        sortRandom3.clear();
        //sortRandom4.clear();
        sortRandom5.clear();
    }

    //TODO: Implement more sort methods

    //Bubble Sort
    //TODO: look for ways to speed up bubbleSort
    //TODO: use cocktail sort?
    public static void bubbleSort(ArrayList<Integer> array){
        System.out.print("   BUBBLE SORT: ");

        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)

        long swaps = 0;
        //take a pair of ints. Compare them. Swap if needed.
        //keeps track of already sorted positions in the array for each pass
        for(int i = 0; i < array.size(); i++){
            for(int j = 1; j < array.size() - i; j++){
                int temp;
              /*if array[i] is greater than array[j] then switch them.
                Do this all the way to the last, then start at array[i]*/
                if(array.get(j - 1) > array.get(j)){
                    temp = array.get(j - 1);
                    array.set(j-1, array.get(j));
                    array.set(j, temp);
                    swaps++;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;

        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swap " + swaps);
    }

    //Selection Sort
    public static void selectionSort(ArrayList<Integer> array){
        System.out.print("SELECTION SORT: ");

        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)
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
        System.out.println(" | swap " + swaps);
    }

    //Insertion Sort
    public static void insertionSort(ArrayList<Integer> array){
        System.out.print("INSERTION SORT: ");
        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)

        long swaps = 0;
        //instantiate j so it may be used outside the 2nd for loop
        //temp will hold the current element in array.get(i) for comparison/swapping later
        int j;
        int temp;
        for(int i = 1; i < array.size(); i++){
            temp = array.get(i);
            //j for loop will be checked and ran as long as array[j] is larger than the array[i] var
            for(j = i - 1; (j >= 0) && (array.get(j) > temp); j--){
                array.set(j+1, array.get(j));
                swaps++;
            }
            //insert current element into array[j+1]
            array.set(j+1, temp);
        }

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;

        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swap " + swaps);
    }

    //Merge Sort
    public static void printMerge(ArrayList<Integer> list){
        System.out.print("   MERGE SORT: ");
        long swaps = 0;
        long startTime = System.currentTimeMillis();

        mergeSort(list);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println();
    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> L) {

        if (L.size() <= 1) {
            return L;
        }

        //Splitting L ArrayList
        ArrayList<Integer> a = new ArrayList<>(L.subList(0, L.size() / 2));
        ArrayList<Integer> b = new ArrayList<>(L.subList(L.size() / 2, L.size()));

        ArrayList<Integer> A = mergeSort(a);
        ArrayList<Integer> B = mergeSort(b);
        return merge(A, B);
    }
    private static ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        int iA = 0;
        int iB = 0;
        ArrayList<Integer> C = new ArrayList<>();

        while (iA < A.size() && iB < B.size()) {
            if(A.get(iA) < B.get(iB)){
                C.add(A.get(iA));
                iA++;
            }
            else{
                C.add(B.get(iB));
                iB++;
            }
        }
        while (iA < A.size()) {
            C.add(A.get(iA));
            iA++;
        }
        while (iB < B.size()) {
            C.add(B.get(iB));
            iB++;
        }
        return C;
    }

    //Radix Sort

    //Quicksort
    public static void printQuickSort(ArrayList<Integer> array){
        System.out.print("    QUICK SORT: ");
        long startTime = System.currentTimeMillis();

        int end = array.size() - 1;
        quickSort(array, 0, end);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println();
    }

    //TODO: Implement best form of Quicksort
    public static ArrayList<Integer> quickSort(ArrayList<Integer> L, int start, int end){
        if (start >= end) {
            return L;
        }
        int pivot = L.get(start+(end-start) / 2);
        int b = start;
        int c = end;
        while(b < c){
            while (L.get(b) < pivot) {
                b++;
            }
            while (L.get(c) > pivot){
                c--;
            }
            if (b <= c) {
                swap(L, b, c);
                b++;
                c--;
            }
        }
        if(start < c){
            return quickSort(L, start, c);
        }
        if(b < end){
            return quickSort(L, pivot + 1, end);
        }
        return L;
    }


    //General swapping function
    public static void swap(ArrayList<Integer> L, int i, int j){
        Integer temp = L.get(j);
        L.set(i, L.get(j));
        L.set(j, temp);
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
            System.out.printf("%3.0f milliseconds", time);
        }
    }
}