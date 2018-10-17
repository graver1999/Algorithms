package by.bsu.hashtable.generate;

import java.util.Random;

public class Generator {
    private long maxValue;
    private int size;
    private int[] array;
    private Random random;

    public Generator(int size, long maxValue) {
        this.maxValue = maxValue;
        this.size = size;
        this.array = new int[this.size];
        random = new Random();
    }

    public void generate() {
        for (int i = 0; i < size; ++i) {
            array[i] = random.nextInt((int)maxValue);
        }
    }

    public int[] getArray() {
        return array;
    }
}
