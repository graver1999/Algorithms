package by.bsu.widewidthSearch.entity;


import java.awt.*;
import java.util.Arrays;


public class Graph {
    public final static double CENTER_X = 350;
    public final static double CENTER_Y = 350;
    public final static double RADIUS = 300;

    private int[][] matrix;
    private Point[] points;

    public Graph() {
    }

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        points = new Point[matrix.length];
        setPoints();
    }

    public Graph(int[][] matrix, Point[] points) {
        this.matrix = matrix;
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private void setPoints() {
        int size = matrix.length;
        double angle = 2 * Math.PI / size;
        for (int i = 0; i < size; ++i) {
            points[i] = new Point((int) (CENTER_X + RADIUS * Math.cos(i * angle)), (int) (CENTER_Y + RADIUS * Math.sin(i * angle)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        return Arrays.deepEquals(matrix, graph.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
