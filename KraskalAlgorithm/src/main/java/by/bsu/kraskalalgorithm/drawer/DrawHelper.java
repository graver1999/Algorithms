package by.bsu.kraskalalgorithm.drawer;

import by.bsu.kraskalalgorithm.entity.*;
import by.bsu.kraskalalgorithm.entity.Point;

import java.awt.*;
import java.util.List;


public class DrawHelper {
    public static final int DIAM = 8;
    public static final int TEXT_INDENT = 15;

    private DrawHelper() {
    }

    public static void drawGraph(Graphics graphics, Graph graph) {
        drawPoints(graphics, graph);
        drawLines(graphics, graph);

    }

    public static void drawAlgorithmResult(Graphics graphics, List<Edge> edges, Graph graph) {
        Point[] points = graph.getPoints();
        graphics.setColor(/*new Color(30,230,0)*/Color.red);
        for (Edge edge : edges) {
            graphics.drawLine(points[edge.getV1() - 1].x + DIAM / 2, points[edge.getV1() - 1].y + DIAM / 2, points[edge.getV2() - 1].x + DIAM / 2, points[edge.getV2() - 1].y + DIAM / 2);
        }
    }


    private static void drawPoints(Graphics graphics, Graph graph) {
        int size = graph.getMatrix().length;
        Point[] points = graph.getPoints();
        for (int i = 0; i < size; ++i) {
            graphics.fillOval(points[i].x, points[i].y, DIAM, DIAM);
            graphics.setColor(Color.black);
            graphics.drawString(String.valueOf(i + 1), points[i].x + TEXT_INDENT, points[i].y + TEXT_INDENT);
        }
    }

    private static void drawLines(Graphics graphics, Graph graph) {
        int size = graph.getMatrix().length;
        Point[] points = graph.getPoints();
        int[][] matrix = graph.getMatrix();
        int vertex;

        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                vertex = matrix[i][j];
                if (vertex > 0) {
                    graphics.setColor(Color.lightGray);
                    graphics.drawLine(points[i].x + DIAM / 2, points[i].y + DIAM / 2, points[j].x + DIAM / 2, points[j].y + DIAM / 2);
                    drawWeight(graphics, points[i], points[j], vertex);
                }
            }
        }
    }


    private static void drawWeight(Graphics graphics, Point v1, Point v2, int weight) {
        graphics.setColor(Color.blue);
        int x = (v1.x + v2.x) / 2;
        int y = (v1.y + v2.y) / 2;
        graphics.drawString(String.valueOf(weight), x, y);
    }


}
