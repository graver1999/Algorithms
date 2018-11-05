package by.bsu.kraskalalgorithm.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Graph {
    public final static double CENTER_X = 350;
    public final static double CENTER_Y = 350;
    public final static double RADIUS = 300;

    private int[][] matrix;
    private Point[] points;
    private List<Edge> edges = new ArrayList<>();

    public Graph() {
    }

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        points = new Point[matrix.length];
        setPoints();
        setEdges();
    }

    public Graph(int[][] matrix, Point[] points) {
        this.matrix = matrix;
        this.points = points;
        setEdges();
    }

    public Graph(int[][] matrix, Point[] points, List<Edge> edges) {
        this.matrix = matrix;
        this.points = points;
        this.edges = edges;
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

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    private void setPoints() {
        int size = matrix.length;
        double angle = 2 * Math.PI / size;
        for (int i = 0; i < size; ++i) {
            points[i] = new Point((int) (CENTER_X + RADIUS * Math.cos(i * angle)), (int) (CENTER_Y + RADIUS * Math.sin(i * angle)));
        }
    }

    private void setEdges() {
        int size = matrix.length;
        for (int j = 1; j < size; ++j) {
            for (int i = 0; i < j; ++i) {
                if (matrix[j][i] > 0) {
                    edges.add(new Edge(i + 1, j + 1, matrix[j][i]));
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Graph graph = (Graph) o;

        if (!Arrays.deepEquals(matrix, graph.matrix)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(points, graph.points);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(matrix);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "matrix=" + Arrays.toString(matrix) +
                ", points=" + Arrays.toString(points) +
                '}';
    }
}
