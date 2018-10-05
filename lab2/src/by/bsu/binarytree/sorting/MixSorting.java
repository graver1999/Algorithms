package by.bsu.binarytree.sorting;


public class MixSorting {
    private int[] array;
    private int[] helper;
    private InsertionSorting is;

    public MixSorting(int[] array) {
        this.array = array;
        //this.array = Arrays.copyOf(array,array.length);
        helper = new int[array.length];
    }

    private void sort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            if (high - low >= 37) {
                sort(low, middle);
                sort(middle + 1, high);
            } else {
                is = new InsertionSorting(array);
                is.doSorting(low, high);
                array = is.getArray();
            }
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; ++i) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k++] = helper[i++];
            } else {
                array[k++] = helper[j++];
            }
        }

        while (i <= middle) {
            array[k++] = helper[i++];
        }
    }

    public void sortMix() {
        sort(0, array.length - 1);
    }

    public int[] getArray() {
        return array;
    }
}
