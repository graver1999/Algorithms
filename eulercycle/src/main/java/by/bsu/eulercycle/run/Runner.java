package by.bsu.eulercycle.run;

import by.bsu.eulercycle.algorithm.EulerCycle;
import by.bsu.eulercycle.drawer.GraphDrawer;
import by.bsu.eulercycle.entity.Graph;
import by.bsu.eulercycle.valid.GraphValidator;


public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0}
        };

        Graph graph = new Graph(matrix);
        GraphDrawer graphDrawer = new GraphDrawer(graph);
        graphDrawer.draw();
        EulerCycle eulerCycle = new EulerCycle(graph);
        eulerCycle.doAlgorithm();
        System.out.println(eulerCycle.getResult());
    }
}