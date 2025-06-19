public class Dijkstra {
    public static int[] dijkstra(Graph graph, int startNode) {
        int n = graph.numZones;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = 999999;
            visited[i] = false;
        }

        distance[startNode] = 0;

        for (int i = 0; i < n; i++) {
            int minDist = 999999;
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distance[j] < minDist) {
                    minDist = distance[j];
                    u = j;
                }
            }

            if (u == -1) break;

            visited[u] = true;

            Edge[] neighbors = graph.getNeighbors(u);
            for (int j = 0; j < neighbors.length; j++) {
                int v = neighbors[j].destination;
                int weight = neighbors[j].travelTime;

                if (!visited[v] && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        return distance;
    }
// This class implements Dijkstra's algorithm to find the shortest path in a graph.
// It uses an adjacency list representation of the graph and maintains a distance array to track the shortest distances.
}