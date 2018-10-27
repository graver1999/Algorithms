package by.bsu.eulercycle.valid;

import by.bsu.eulercycle.entity.Graph;


public final class GraphValidator {

    private GraphValidator() {
    }

    public static boolean isEulerCycle(Graph graph) {
        int[][] matrix = graph.getMatrix();
        int numberVertexes = 0;

        for (int[] vertexes : matrix) {
            numberVertexes = 0;
            for (int vertex : vertexes) {
                if (vertex == 1) {
                    numberVertexes++;
                }
            }

            if (numberVertexes % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
