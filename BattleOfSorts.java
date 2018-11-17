import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BattleOfSorts {
    public static void main(String[] args) {
        //get input of user's desired amount of ints in arrays
        Scanner input = new Scanner(System.in);
        int arrayOfInts;
        /*input number of ints for each list
          Must be a positive integer above 0
        */
        //input for if user allows an array w/ over 300K elements is input
        Scanner verifyBigInt = new Scanner(System.in);

        do {
            System.out.print("How many integers in the arrays for this test?: ");
            while (!input.hasNextInt()) {
                System.out.print("Must be positive int!: ");
                input.next();
            }
            arrayOfInts = input.nextInt();
            if (arrayOfInts >= 300000) {
                boolean yn;
                System.out.println("Arrays w/ 300K or more elements may take an extremely long time depending on machine!");
                System.out.print("Do you still want to continue? y/n: ");
                do{
                    //TODO: Remove spaces from input
                    switch (verifyBigInt.next().toLowerCase()) {
                        case "y":
                            yn = true;
                            break;
                        case "n":
                            System.out.print("New arrays amount: ");
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

        //TODO: Convert list creation into methods
        //ORDERED LIST
        //Create sortOrdered

        //public static double[] Ordered(int arrayOfInts) {
            double[] sortOrdered = new double[arrayOfInts];
            for(int i = 0; i < arrayOfInts; i++){
                sortOrdered[i] = i;
            }
        //    return sortOrdered;
        //}

        //REVERSED LIST
        //Create Reversed version of sortOrdered
        double[] sortReversed = new double[arrayOfInts];
        for(int i = 0; i < arrayOfInts; i++){
            //array length - 1 - current loop number; eg. 10 - 1 - 5 = 4
            sortReversed[i] = arrayOfInts - 1 - i;
        }
        //RANDOM LIST
        //Make Random object, the new array to be sorted, and an ArrayList object that will be modified later
        Random randInt = new Random();
        double[] sortRandom = new double[arrayOfInts];
        ArrayList<Integer> ints = new ArrayList<>();
        //populate the array w/ a list in numerical order
        for(int i = 0;i < arrayOfInts; i++){
            ints.add(i);
        }
        //comb through the array list; replace each index of the array w/ a random number not already in the array list
        for(int i = 0;i < arrayOfInts; i++){
            int j = ints.remove(randInt.nextInt(ints.size()));
            sortRandom[i] = j;
        }

        //TODO: Remove clones once methods implemented
        //LIST CLONES
        //make 3 extra clones of each array since each will be sorted once sort method is finished
        double[] sortOrdered1 = sortOrdered.clone();
        double[] sortOrdered2 = sortOrdered.clone();
        double[] sortOrdered3 = sortOrdered.clone();
        double[] sortReversed1 = sortReversed.clone();
        double[] sortReversed2 = sortReversed.clone();
        double[] sortReversed3 = sortReversed.clone();
        double[] sortRandom1 = sortRandom.clone();
        double[] sortRandom2 = sortRandom.clone();
        double[] sortRandom3 = sortRandom.clone();


        //TODO: Do other required tedious stuff here
        //Call each sort method using each array
        //Ordered sort
        System.out.printf("%26s%n", "---ORDERED LIST---");
        bubbleSort(sortOrdered);
        selectionSort(sortOrdered1);
        insertionSort(sortOrdered2);
        quickSort(sortOrdered3);

        System.out.println();

        //Reversed sort
        System.out.printf("%27s%n", "---REVERSED LIST---");
        bubbleSort(sortReversed);
        selectionSort(sortReversed1);
        insertionSort(sortReversed2);
        quickSort(sortReversed3);

        System.out.println();

        //Random sort
        System.out.printf("%25s%n", "---RANDOM LIST---");
        bubbleSort(sortRandom);
        selectionSort(sortRandom1);
        insertionSort(sortRandom2);
        quickSort(sortRandom3);
    }


    //TODO: Implement more sort methods
    //TODO: Do more required tedious stuff related to the stuff up top
    //Bubble Sort
    public static void bubbleSort(double[] array){
        System.out.print("   BUBBLE SORT: ");

        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)

        long swaps = 0;
        //take a pair of ints. Compare them. Swap if needed.
        //keeps track of already sorted positions in the array for each pass
        for(int i = 0; i < array.length; i++){
            for(int j = 1; j < array.length - i; j++){
                double temp;
              /*if array[i] is greater than array[j] then switch them.
                Do this all the way to the last, then start at array[i]*/
                if(array[j - 1] > array[j]){
                    temp = array[j - 1];
                    array[j-1] = array[j];
                    array[j] = temp;
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
    public static void selectionSort(double[] array){
        System.out.print("SELECTION SORT: ");

        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)
        long swaps = 0;
        //first find the min. number by combing the array, then swap w/ current index
        //repeat. w/ index place increasing by one until you reach the last key
      /*since the last key will already be the largest in the list, time
          can be saved by excluding it in the for loop*/
        for(int i = 0; i < array.length - 1; i++){
            //minIndex will be used to keep track of which indexes in the array were already passed through
            double min = array[i];
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
          /*if i and index are not equal, swap array[index] and array[i];
            use a temp to hold array[index] for later declaration in array[i]*/
            if(minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
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
    public static void insertionSort(double[] array){
        System.out.print("INSERTION SORT: ");
        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)

        long swaps = 0;
        //instantiate j so it may be used outside the 2nd for loop
        //temp will hold the current element in array[i] for comparison/swaping later
        int j;
        double temp;
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            //j for loop will be checked and ran as long as array[j] is larger than the array[i] var
            for(j = i - 1; (j >= 0) && (array[j] > temp); j--){
                array[j+1] = array[j];
                swaps++;
            }
            //insert current element into array[j+1]
            array[j+1] = temp;
        }

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;

        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println(" | swap " + swaps);
    }

    //Quicksort
    public static void quickSort(double[] array){
        System.out.print("    QUICK SORT: ");
        long startTime = System.currentTimeMillis();
        // perform the task (i.e., call the appropriate method)

        Arrays.sort(array);

        long endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        //return run time of sorting + swaps
        printTime(executionTime);
        System.out.println();
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