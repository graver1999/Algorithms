package by.bsu.primalgorithm.entity;


public class Edge {
    private int v1;
    private int v2;
    private int weight;
    private boolean visited;

    public Edge() {
    }

    public Edge(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
        weight = 0;
        visited = false;
    }

    public int getV1() {
        return v1;
    }

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        visited = false;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (v1 != edge.v1 && v1 != edge.v2) return false;
        if (v2 != edge.v2 && v2 != edge.v1) return false;
        return weight == edge.weight;
    }

    @Override
    public int hashCode() {
        int result = v1;
        result = 31 * result + v2;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", weight=" + weight +
                '}';
    }
}
