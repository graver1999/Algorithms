package by.bsu.primalgorithm.drawer;

import by.bsu.primalgorithm.algorithm.PrimAlgorithm;
import by.bsu.primalgorithm.entity.Graph;

import javax.swing.*;
import java.awt.*;


public class GraphDrawer extends JPanel {
    public static final int PANEL_WIDTH = 700;
    public static final int PANEL_HEIGHT = 700;
    public static final int SLEEP = 2500;

    private Graph graph;
    private JFrame frame = new JFrame();
    private PrimAlgorithm primAlgorithm;
    private int vertexStart;
    private boolean flag;

    {
        flag = true;
    }

    public GraphDrawer() {
    }

    public GraphDrawer(Graph graph, int vertexStart) {
        this.graph = graph;
        this.vertexStart = vertexStart;
        primAlgorithm = new PrimAlgorithm(graph);
        primAlgorithm.doAlgorithm1(vertexStart);
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
        DrawHelper.drawAlgorithmResult(graphics, primAlgorithm.getResult(), graph);

        if (!primAlgorithm.isAllResultVertexes()) {
            primAlgorithm.doAlgorithmCycle(vertexStart);

            repaint();
        } else if (flag) {
            flag = false;
            System.out.println(primAlgorithm.getResult());
            System.out.println(primAlgorithm.getResultVertexes());
            System.out.println(primAlgorithm.getTreeWeight());
        }

        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
