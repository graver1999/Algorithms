package by.bsu.widewidthSearch.run;

import by.bsu.widewidthSearch.action.WideWidthSearch;
import by.bsu.widewidthSearch.drawer.GraphDrawer;
import by.bsu.widewidthSearch.entity.Graph;


public class Runner {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{0, 1, 0, 0, 1, 1},
                {1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 0}};

        int[][] matrix2 = new int[][]{{0, 0, 0, 0, 1, 1},
                                     {0, 0, 0, 1, 0, 0},
                                     {0, 0, 0, 1, 0, 0},
                                     {0, 1, 1, 0, 0, 0},
                                     {1, 0, 0, 0, 0, 0},
                                     {1, 0, 0, 0, 0, 0}};

        int[][] matrix3 = new int[][]{{0, 0, 0, 0, 0, 0, 1, 0, 0},
                                      {0, 0, 1, 1, 0, 0, 0, 1, 0},
                                      {0, 1, 0, 0, 1, 0, 0, 0, 0},
                                      {0, 1, 0, 0, 0, 1, 1, 0, 0},
                                      {0, 1, 1, 0, 0, 1, 0, 0, 0},
                                      {0, 0, 0, 1, 1, 0, 1, 0, 0},
                                      {1, 0, 0, 1, 0, 1, 0, 1, 0},
                                      {0, 1, 0, 0, 0, 0, 1, 0, 0},
                                      {0, 0, 0, 0, 0, 0, 0, 0, 0}};


        Graph graph = new Graph(matrix1);
        GraphDrawer gw = new GraphDrawer(graph);
        gw.draw();
        WideWidthSearch wideWidthSearch = new WideWidthSearch(graph);
        wideWidthSearch.doSearch();
        System.out.println(wideWidthSearch.isConnectedGraph());
        System.out.println(wideWidthSearch.getVertex());



    }
}
