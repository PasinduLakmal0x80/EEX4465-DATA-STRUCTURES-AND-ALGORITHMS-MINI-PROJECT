import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Testing the ParcelRequestManagement class
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(new ParcelRequestManagement(1, "Colombo", LocalDate.now(), LocalDate.now().minusDays(1), false));
        maxHeap.insert(new ParcelRequestManagement(2, "Kandy", LocalDate.now().plusDays(1), LocalDate.now().minusDays(2), true));
        maxHeap.insert(new ParcelRequestManagement(3, "Galle", LocalDate.now().plusDays(2), LocalDate.now().minusDays(3), false));
        maxHeap.insert(new ParcelRequestManagement(4, "Matara", LocalDate.now(), LocalDate.now().minusDays(1), true));

        System.out.println("Extracted in priority order:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
        System.out.println("\n");

        // Testing the VehicleHashTable
        VehicleHashTable vehicleHashTable = new VehicleHashTable();
        VehicleFleetTracking v1 = new VehicleFleetTracking(1, "Colombo", 50, true);
        VehicleFleetTracking v2 = new VehicleFleetTracking(2, "Kandy", 30, false);

        vehicleHashTable.put("Colombo", v1);
        vehicleHashTable.put("Kandy", v2);

        System.out.println("Colombo Fleet: " + vehicleHashTable.get("Colombo"));
        System.out.println("Kandy Fleet: " + vehicleHashTable.get("Kandy"));
        System.out.println("Galle Fleet: " + vehicleHashTable.get("Galle")); // Should be null

        // Delivery Route Planning and Dijkstra's Algorithm
        Graph graph = new Graph(6); // Zones: 0 to 5

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 2);

        int source = 0;
        int[] shortestDistances = Dijkstra.dijkstra(graph, source);

        System.out.println("Shortest distances from zone " + source + ":");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("To zone " + i + " = " + shortestDistances[i]);
    }
    }
}
