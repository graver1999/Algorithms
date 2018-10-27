package by.bsu.eulercycle.drawer;

import by.bsu.eulercycle.algorithm.EulerCycle;
import by.bsu.eulercycle.entity.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GraphDrawer extends JPanel {
    public static final int PANEL_WIDTH = 700;
    public static final int PANEL_HEIGHT = 700;

    private Graph graph;
    private JFrame frame = new JFrame();

    public GraphDrawer() {
    }

    public GraphDrawer(Graph graph) {
        this.graph = graph;
    }

    public void draw() {
        frame.setLocation(150, 0);
        frame.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        DrawHelper.drawGraph(graphics, graph);
    }
}
