package by.bsu.widewidthSearch.action;

import by.bsu.widewidthSearch.entity.Graph;

import java.util.*;


public final class WideWidthSearch {
    private Graph graph;
    private Map<Integer, Integer> vertex = new HashMap<>();
    private int size;
    private int[][] matrix;
    private Deque<Integer> list1 = new LinkedList<>();
    private Deque<Integer> list2 = new LinkedList<>();

    public WideWidthSearch() {
    }

    public WideWidthSearch(Graph graph) {
        this.graph = graph;
        size = graph.getMatrix().length;
        matrix = graph.getMatrix();
    }

    private void searchHelper(Deque<Integer> list1, Deque<Integer> list2, int remark) {
        while (!list2.isEmpty()) {
            for (int i = 0; i < size; ++i) {
                if (!vertex.containsKey(i + 1) && matrix[list2.peek()][i] == 1) {
                    list1.add(i);
                    vertex.put(i + 1, remark);
                }
            }
            list2.pop();
        }
    }

    public void doSearch() {
        vertex.put(1,0);
        list2.add(0);
        int remark = 0;
        while (!list2.isEmpty() || !list1.isEmpty()) {
            searchHelper(list1, list2, remark + 1);
            searchHelper(list2,list1, remark + 2);
            remark += 2;
        }
    }


    public boolean isConnectedGraph() {
        return vertex.size() == graph.getMatrix().length;
    }

    public Map<Integer, Integer> getVertex() {
        return vertex;
    }
}
