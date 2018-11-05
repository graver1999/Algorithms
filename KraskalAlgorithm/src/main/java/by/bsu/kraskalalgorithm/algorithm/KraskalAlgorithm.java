package by.bsu.kraskalalgorithm.algorithm;

import by.bsu.kraskalalgorithm.entity.Edge;
import by.bsu.kraskalalgorithm.entity.Graph;
import java.lang.reflect.Array;
import java.util.*;


public class KraskalAlgorithm {
    private int[][] matrix;
    private int size;
    private List<Edge> result = new ArrayList<>();
    private Map<Integer, Integer> remarks = new HashMap<>();

    public KraskalAlgorithm() {
    }

    public KraskalAlgorithm(Graph graph) {
        matrix = graph.getMatrix();
        size = matrix.length;
        setRemarks();
    }

    public List<Edge> getResult() {
        return result;
    }

    public void doAlgorithm() {
        Edge edge;
        //while (!isEnd()) {
        edge = getMinEdge();
        changeRemark(remarks.get(edge.getV2()), remarks.get(edge.getV1()));
        result.add(edge);
        //}
    }

    public int getTreeWeight() {
        int totalWeight = 0;
        for (Edge edge : result) {
            totalWeight += edge.getWeight();
        }
        return totalWeight;
    }

    public boolean isEnd() {
        return result.size() == size - 1;
    }

    private void setRemarks() {
        for (int i = 0; i < size; ++i) {
            remarks.put(i + 1, i + 1);
        }
    }

    private Edge getMinEdge() {
        int min = Integer.MAX_VALUE;
        Edge edge = new Edge();

        for (int j = 0; j < size; ++j) {
            for (int i = 0; i < size; ++i) {
                if (matrix[j][i] > 0 && matrix[j][i] < min) {
                    if (remarks.get(j + 1) != remarks.get(i + 1)) {
                        min = matrix[j][i];
                        edge = new Edge(j + 1, i + 1, matrix[j][i]);
                    }
                }
            }
        }
        return edge;
    }

    private void changeRemark(int old, int recent) {
        for (int i = 0; i < size; ++i) {
            if (remarks.get(i + 1) == old) {
                remarks.put(i + 1, recent);
            }
        }
    }
}
