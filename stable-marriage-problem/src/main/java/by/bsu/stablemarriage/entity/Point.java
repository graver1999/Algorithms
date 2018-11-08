package by.bsu.stablemarriage.entity;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Point extends java.awt.Point {
    private Deque<Integer> wants = new LinkedList<>();
    private Status status;
    private int i;

    public Point() {
    }

    public Point(int x, int y) {
        super(x, y);
        status = Status.FREE;
    }

    public Point(int x, int y, int[] wants) {
        this(x, y);
    }

    public Point(int i) {
        status = Status.FREE;
        this.i = i;
    }

    public Point(int x, int y, int i) {
        this(x, y);
        this.i = i;
    }

    public Deque<Integer> getWants() {
        return wants;
    }

    public void setWants(int[] wants) {
        for (int want : wants) {
            this.wants.add(want);
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getI() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Point point = (Point) o;

        if (i != point.i) return false;
        if (wants != null ? !wants.equals(point.wants) : point.wants != null) return false;
        return status == point.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wants != null ? wants.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + i;
        return result;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Point{" +
                "wants=" + Arrays.toString(wants.toArray()) +
                " status=" + status +
                '}';
    }
}

