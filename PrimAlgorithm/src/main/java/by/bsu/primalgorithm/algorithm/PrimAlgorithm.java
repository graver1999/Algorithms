package by.bsu.primalgorithm.algorithm;

import by.bsu.primalgorithm.entity.Edge;
import by.bsu.primalgorithm.entity.Graph;

import java.util.ArrayList;
import java.util.List;


public class PrimAlgorithm {
    private List<Edge> result = new ArrayList<>();
    private List<Integer> resultVertexes = new ArrayList<>();
    private int[][] matrix;
    private int size;

    public PrimAlgorithm() {
    }

    public PrimAlgorithm(Graph graph) {
        matrix = graph.getMatrix();
        size = matrix.length;
    }

    public List<Edge> getResult() {
        return result;
    }

    public List<Integer> getResultVertexes() {
        return resultVertexes;
    }


    public void doAlgorithm1(int start){
        resultVertexes.add(start);
    }

    public void doAlgorithmCycle(int start) {
        Edge edge;
        //while (!isAllResultVertexes()) {
            edge = getMinAdjacentEdge();
            result.add(edge);
            resultVertexes.add(edge.getV2());
        //}
    }

    public int getTreeWeight() {
        int totalWeight = 0;
        for (Edge edge : result) {
            totalWeight += edge.getWeight();
        }
        return totalWeight;
    }

    private Edge getMinAdjacentEdge() {
        int min = Integer.MAX_VALUE;
        Edge edge = new Edge();

        for (int vertex : resultVertexes) {
            for (int i = 0; i < size; ++i) {
                if (matrix[vertex - 1][i] > 0 && matrix[vertex - 1][i] < min) {
                    if (!result.contains(new Edge(vertex, i + 1, matrix[vertex - 1][i])) && !cycle(i + 1)) {
                        min = matrix[vertex - 1][i];
                        edge = new Edge(vertex, i + 1, matrix[vertex - 1][i]);
                    }
                }
            }
        }
        return edge;
    }

    public boolean isAllResultVertexes() {
        return resultVertexes.size() == size;
    }

    private boolean cycle(int vertex) {
        return resultVertexes.contains(vertex);
    }


}
