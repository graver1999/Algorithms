package by.bsu.kraskalalgorithm.drawer;

import by.bsu.kraskalalgorithm.algorithm.KraskalAlgorithm;
import by.bsu.kraskalalgorithm.entity.Graph;

import javax.swing.*;
import java.awt.*;


public class GraphDrawer extends JPanel {
    public static final int PANEL_WIDTH = 700;
    public static final int PANEL_HEIGHT = 700;
    public static final int SLEEP = 2500;

    private Graph graph;
    private JFrame frame = new JFrame();
    private KraskalAlgorithm kraskalAlgorithm;
    private boolean flag;

    {
        flag = true;
    }

    public GraphDrawer() {
    }

    public GraphDrawer(Graph graph) {
        this.graph = graph;
        kraskalAlgorithm = new KraskalAlgorithm(graph);
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
        DrawHelper.drawAlgorithmResult(graphics, kraskalAlgorithm.getResult(), graph);

        if (!kraskalAlgorithm.isEnd()) {
            kraskalAlgorithm.doAlgorithm();
            repaint();
        } else if (flag) {
            flag = false;
            System.out.println(kraskalAlgorithm.getResult());
            System.out.println(kraskalAlgorithm.getTreeWeight());
        }

        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
