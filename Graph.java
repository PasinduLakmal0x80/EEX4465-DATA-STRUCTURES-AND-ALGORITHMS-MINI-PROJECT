public class Graph {
    int numZones;
    Edge[][] adjList;

    public Graph(int numZones) {
        this.numZones = numZones;
        adjList = new Edge[numZones][];
        for (int i = 0; i < numZones; i++) {
            adjList[i] = new Edge[0];
        }
    }

    public void addEdge(int source, int destination, int travelTime) {
        Edge newEdge = new Edge(destination, travelTime);
        Edge[] oldList = adjList[source];
        Edge[] newList = new Edge[oldList.length + 1];
        for (int i = 0; i < oldList.length; i++) {
            newList[i] = oldList[i];
        }
        newList[oldList.length] = newEdge;
        adjList[source] = newList;
    }

    public Edge[] getNeighbors(int node) {
        return adjList[node];
    }
}
