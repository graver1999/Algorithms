package by.bsu.binarytree.sorting;

import java.util.Arrays;

public class InsertionSorting {
    private int[] array;

    public InsertionSorting(int[] array) {
        this.array = array;
       // this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return array;
    }

    public void doSorting(int low, int high) {
        int x;
        int j;
        for (int i = low + 1; i <= high; ++i) {
            x = array[i];
            j = i;
            while (j > low && array[j - 1] > x) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = x;
        }
    }
}
