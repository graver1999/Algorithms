package by.bsu.eulercycle.algorithm;

import by.bsu.eulercycle.entity.Graph;
import by.bsu.eulercycle.valid.GraphValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class EulerCycle {
    private Graph graph;
    private Stack<Integer> stack = new Stack<>();
    private List<Integer> result = new ArrayList<>();
    private int[][] matrix;
    private int size;

    public EulerCycle() {
    }

    public EulerCycle(Graph graph) {
        this.graph = graph;
        size = graph.getMatrix().length;
        matrix = copyMatrix(graph.getMatrix());

    }

    public void doAlgorithm() {
        if (GraphValidator.isEulerCycle(graph)) {
            stack.push(0);
            while (!stack.isEmpty()) {
                if (degreeIsZero(stack.peek())) {
                    result.add(stack.pop() + 1);
                } else {
                    int end = -1;
                    for (int i = 0; i < size; ++i) {
                        if (matrix[stack.peek()][i] == 1) {
                            matrix[stack.peek()][i] = 0;
                            matrix[i][stack.peek()] = 0;
                            end = i;
                            break;
                        }
                    }
                    stack.push(end);
                }
            }
        }
    }

    public List<Integer> getResult() {
        return result;
    }

    private boolean degreeIsZero(int vertex) {
        int size = matrix[vertex].length;
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (matrix[vertex][i] == 1) {
                count++;
            }
        }

        return count == 0;
    }

    private int[][] copyMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] matrixResult = Arrays.copyOf(matrix, size);
        for (int i = 0; i < size; ++i) {
            matrixResult[i] = Arrays.copyOf(matrix[i], size);
        }
        return matrixResult;
    }

}
