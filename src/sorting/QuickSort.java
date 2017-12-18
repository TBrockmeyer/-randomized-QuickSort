package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void swap(int[] A, int i, int j) {

        // Ensuring that i and j don't lie outside the boundaries of array A
        if (i < 0 || i > (A.length-1) || j < 0 || j > (A.length-1)) {
            throw new IllegalArgumentException();
        }

        // Swapping values of elements at indices i and j
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    //
//
    public static int partition(int[] A, int l, int r) {

        // If given indices of l and r unreachable or inappropriate (e.g. l>r), throw exception
        if (!(0 <= l && l <= r && r < (A.length))) {
            throw new IllegalArgumentException();
        }

        // The pivot element is the last element of the given Array
        int pivot = A[r];
        int i = l;
        // Compare every element in given Array
        for (int j = l; j<=(r-1); j = j+1){
            if (A[j] <= pivot){
                // If current element smaller or equal pivot element, swap indices
                swap(A,i,j);
                // As all elements from 0 to i have been sorted already,
                // element i+1 is the next candidate for a boundary element for swapping
                i = i+1;
            }
        }

        swap(A,i,r);

        return i;

    }


    public static void quickSort(int[] A, int l, int r) {
        // If given indices of l and r unreachable or inappropriate (e.g. l>r), throw exception
        System.out.println("l = " + l + "; r = " + r + "; A.length = " + A.length);
        if (!(0 <= l && l <= r && r <= (A.length))) {
            throw new IllegalArgumentException();
        }

        if(l<r) {
            int m = partition(A, l, r);
            System.out.println("quickSort1(" + java.util.Arrays.toString(A) + ", " + l + ", (" + (m - 1) + "));");
            if(l<=(m-1)) {quickSort(A, l, (m - 1));}
            System.out.println("quickSort2(" + java.util.Arrays.toString(A) + ", " + (m + 1) + ", (" + r + "));");
            if((m+1)<=r) {quickSort(A, (m + 1), r);}
        }

    }

    public static void quickSort(int[] A) {
        // This method allows sorting by giving merely the whole Array A to quickSort (method overload)
        int l = 0;  // TODO
        int r = A.length-1;  // TODO
        quickSort(A, l, r);
    }


    public static int randomizedPartition(int[] A, int l, int r) {
        // TODO: Teil c)
        if (!(0 <= l && l <= r && r < (A.length))) {
            throw new IllegalArgumentException();
        }
        Random rand = new Random();
        int k = rand.nextInt(((r)-l+1))+(l);
        swap(A, r, k);
        return partition(A, l, r);
    }


    public static void randomizedQuickSort(int[] A, int l, int r) {
        // If given indices of l and r unreachable or inappropriate (e.g. l>r), throw exception
        if (!(0 <= l && l <= r && r < (A.length))) {
            throw new IllegalArgumentException();
        }

        if(l<r) {
            int m = randomizedPartition(A, l, r);
            System.out.println("randomizedQuickSort1(" + java.util.Arrays.toString(A) + ", " + l + ", (" + (m - 1) + "));");
            if(l<=(m-1)) {randomizedQuickSort(A, l, (m - 1));}
            System.out.println("randomizedQuickSort2(" + java.util.Arrays.toString(A) + ", " + (m + 1) + ", (" + r + "));");
            if((m+1)<=r) {randomizedQuickSort(A, (m + 1), r);}
        }
    }

    public static void randomizedQuickSort(int[] A) {
        // This method allows sorting by giving merely the whole Array A to randomizedQuickSort (method overload)
        int l = 0;
        int r = A.length-1;
        randomizedQuickSort(A, l, r);
    }


    public static void main(String[] args) {

        // This main method simply exists for testing all other methods inside this Class

        Random rand = new Random();
        final int n = 25;
        // generiere ein Array mit n ganzzahligen Elementen im Intervall [0, n]
        int[] A = rand.ints(n, 0, n).toArray();

        // As randomizedQuickSort works in-place, we copy A to Array B
        // in order to see the difference before and after sorting
        int[] B = Arrays.copyOf(A, A.length);

        // We currently test the randomizedQuickSort method here;
        // if the "normal" quickSort shall be tested, uncomment next line and comment line after
        // QuickSort(A);
        randomizedQuickSort(A);

        // Test cases with special properties:

        // Testing for several zeros as first elements, which could lead to errors in partitioning
        // (but caught by "[only] if(l<=r)" rules)

        //int[] C = {0, 0, 1, 7, 2, 6, 6, 5, 7, 7, 16, 12, 14, 14, 13, 10, 15, 14, 12, 11, 18, 9, 22, 13, 17};
        //quickSort(C);
        //System.out.println("C: " + java.util.Arrays.toString(C));

        //int[] E = {0, 0, 0, 10, 5, 7, 2, 7, 5, 3, 10, 19, 23, 18, 20, 18, 18, 21, 22, 24, 21, 23, 23, 24, 16};
        //randomizedQuickSort(E);
        //System.out.println("E: " + java.util.Arrays.toString(E));

        // Testing for false input to partitioning
        // (but caught by "[only] if(l<=r)" rules)

        //int[] D = {0, 2, 1, 3};
        //randomizedQuickSort(D, 2, 1);
        //System.out.println("D: " + java.util.Arrays.toString(D));

        //int[] F = {11, 23, 2, 1, 14, 11, 5, 2, 20, 23, 4, 19, 13, 23, 24, 24, 20, 16, 5, 2, 21, 14, 7, 9, 8};
        //randomizedQuickSort(F, 3, 15);
        //randomizedQuickSort(F);
        //System.out.println("F: " + java.util.Arrays.toString(F));

        System.out.println("A previously:  " + java.util.Arrays.toString(B));
        System.out.println("A after sorting: " + java.util.Arrays.toString(A));


    }


}

