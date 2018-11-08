package by.bsu.stablemarriage.entity;


public class Pair {
    private int man;
    private int woman;

    public Pair() {
    }

    public Pair(int man, int woman) {
        this.man = man;
        this.woman = woman;
    }

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return man + "=" + woman;
    }
}
