package by.bsu.widewidthSearch.drawer;

import by.bsu.widewidthSearch.entity.Graph;

import java.awt.*;


public final class DrawHelper {
    private DrawHelper() {
    }

    public static void drawGraph(Graphics graphics, Graph graph) {
        drawPoints(graphics, graph);
        drawLines(graphics, graph);

    }

    private static void drawPoints(Graphics graphics, Graph graph) {
        int size = graph.getMatrix().length;
        Point[] points = graph.getPoints();
        for (int i = 0; i < size; ++i) {
            graphics.fillOval(points[i].x, points[i].y, 8, 8);
            graphics.drawString("" + (i + 1), points[i].x + 10, points[i].y + 10);
        }
    }

    private static void drawLines(Graphics graphics, Graph graph) {
        int size = graph.getMatrix().length;
        Point[] points = graph.getPoints();
        int[][] matrix = graph.getMatrix();
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (matrix[i][j] == 1) {
                    graphics.drawLine(points[i].x + 4, points[i].y + 4, points[j].x + 4, points[j].y + 4);
                }
            }
        }
    }

}
