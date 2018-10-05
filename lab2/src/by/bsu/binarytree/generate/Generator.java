package by.bsu.binarytree.generate;

import java.util.Random;


public class Generator {
    private int size;
    private int maxValue;
    private int[] array;
    private Random random = new Random();

    public Generator(int size, int maxValue) {
        this.size = size;
        this.maxValue = maxValue;
        array = new int[size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getArray(){
        return array;
    }

    public void generateArray(){
        for(int i = 0; i < size; ++i) {
            array[i] = random.nextInt(maxValue);
        }
    }
}
