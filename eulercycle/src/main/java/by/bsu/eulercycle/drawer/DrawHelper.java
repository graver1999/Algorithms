package by.bsu.eulercycle.drawer;

import by.bsu.eulercycle.entity.Graph;
import by.bsu.eulercycle.drawer.action.LineAngle;

import java.awt.*;
import java.util.Map;



public class DrawHelper {
    public static final int DIAM = 8;
    public static final int TEXT_INDENT = 10;

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
            graphics.fillOval(points[i].x, points[i].y, DIAM, DIAM);
            graphics.drawString("" + (i + 1), points[i].x + TEXT_INDENT, points[i].y + TEXT_INDENT);
        }
    }

    private static void drawLines(Graphics graphics, Graph graph) {
        int size = graph.getMatrix().length;
        Point[] points = graph.getPoints();
        int[][] matrix = graph.getMatrix();

        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (matrix[i][j] > 0) {
                    graphics.setColor(Color.black);
                    graphics.drawLine(points[i].x + DIAM / 2, points[i].y + DIAM / 2, points[j].x + DIAM / 2, points[j].y + DIAM / 2);
                }
            }
        }
    }
}
