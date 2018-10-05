package by.bsu.binarytree.searches;


public class InterpolationSearch {
    private int[] array;
    private int position;
    private int iteration;
    private int wantedNumber;

    public InterpolationSearch(int[] array, int wantedNumber) {
        this.array = array;
        this.wantedNumber = wantedNumber;
    }

    private void findPositionWantedNumber(long low, long high) {
        iteration++;
        if (array[(int)low] < wantedNumber && wantedNumber < array[(int)high]) {

            long middle = low + ((high - low) * (wantedNumber - array[(int) low])) / (array[(int) high] - array[(int) low]);

            if (wantedNumber > array[(int) middle]) {
                findPositionWantedNumber((int) middle + 1, high);
            } else {
                findPositionWantedNumber(low, middle);
            }
        } else {
            if (array[(int) high] == wantedNumber) {
                position = (int) high;
            } else if (array[(int) low] == wantedNumber) {
                position = (int) low;
            } else position = -1;
        }
    }

    public int searchPosition() {
        findPositionWantedNumber(0, array.length - 1);
        return position;
    }

    public int getIteration() {
        return iteration;
    }

}
