package by.bsu.stablemarriage.run;

import by.bsu.stablemarriage.algorithm.StableMarriage;
import by.bsu.stablemarriage.entity.Graph;



public class Runner {
    public static void main(String[] args) {
        int[][] wants = {
                {3, 1, 4, 2, 5}, {3, 4, 2, 1, 5}, {5, 1, 3, 4, 2}, {4, 5, 3, 2, 1}, {2, 3, 4, 5, 1},
                {2, 5, 4, 1, 3}, {3, 2, 5, 4, 1}, {3, 4, 1, 5, 2}, {5, 3, 4, 1, 2}, {1, 2, 3, 4, 5}
        };
        Graph graph = new Graph(wants);
        StableMarriage stableMarriage = new StableMarriage(graph);
        stableMarriage.doAlgorithm();
        System.out.println(stableMarriage.getMarriages());
    }
}
