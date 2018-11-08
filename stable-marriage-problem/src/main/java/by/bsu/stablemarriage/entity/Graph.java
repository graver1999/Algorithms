package by.bsu.stablemarriage.entity;

import java.util.Arrays;


public class Graph {
    public final static double CENTER_X = 350;
    public final static double CENTER_Y = 350;
    public final static double RADIUS = 300;

    private int[][] matrix;
    private Point[] points;
    private int[][] wants;

    public Graph() {
    }

    public Graph(int[][] matrix, Point[] points) {
        this.matrix = matrix;
        this.points = points;
    }

    public Graph(int[][] wants) {
        this.wants = wants;
        points = new Point[wants.length];
        setPoints();
        setPointsWants();
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public int[][] getWants() {
        return wants;
    }

    public void setWants(int[][] wants) {
        this.wants = wants;
    }

    private void setPoints() {
        int size = wants.length;
        double angle = 2 * Math.PI / size;
        for (int i = 0; i < size; ++i) {
            points[i] = new Point(i + 1);
        }
    }

    private void setPointsWants() {
        int size = points.length;
        for (int i = 0; i < size; ++i) {
            points[i].setWants(wants[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (!Arrays.deepEquals(matrix, graph.matrix)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(points, graph.points)) return false;
        return Arrays.deepEquals(wants, graph.wants);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(matrix);
        result = 31 * result + Arrays.hashCode(points);
        result = 31 * result + Arrays.deepHashCode(wants);
        return result;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "matrix=" + Arrays.toString(matrix) +
                ", points=" + Arrays.toString(points) +
                ", wants=" + Arrays.toString(wants) +
                '}';
    }
}
