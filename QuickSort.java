import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    private static ArrayList<Integer> array = new ArrayList<Integer>();
    private static int swaps;

    public QuickSort(ArrayList<Integer> array){
        QuickSort.array = array;
    }

    public int getSwaps(){
        return swaps;
    }

    public void quickSort(int start, int end){
        int pivot;
        if(start<end){
            pivot = partition(start, end);
            quickSort(start, pivot);
            quickSort(pivot+1, end);
        }
    }

    int partition(int start, int end){
        int a = start;
        int b = end;

        Random r = new Random();
        int pivotIndex = nextRndInt(start,end,r);
        int pivot = array.get(pivotIndex);

        while(true){
            while(array.get(a) < pivot && a < end){
                a++;
            }
            while(array.get(b) > pivot && b > start){
                b--;
            }
            if(a < b){
                int temp;
                temp = array.get(a);
                array.set(a,array.get(b));
                array.set(b,temp);
                swaps++;
                b--;
                a++;
            }
            else{
                return b;
            }
        }
    }

    // Below method is to just find random integer from given range
    static int nextRndInt(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot instantiate random int from invalid range [" + min + ", " + max + "]!");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
    }
}