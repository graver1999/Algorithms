package by.bsu.primalgorithm.entity;


public class Point extends java.awt.Point {
    private boolean visited;
    private int weight;

    public Point() {
    }

    public Point(int x, int y) {
        super(x, y);
        visited = false;
        weight = Integer.MAX_VALUE;
    }

    public Point(int x, int y, boolean visited) {
        super(x, y);
        this.visited = visited;
        weight = Integer.MAX_VALUE;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Point point = (Point) o;

        return visited == point.visited;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (visited ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }
}

