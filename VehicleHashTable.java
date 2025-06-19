// Hash table implementation to store Vehicles by region (key)
// Uses separate chaining to handle hash collisions
public class VehicleHashTable {

    // Size of the hash table (number of buckets)
    private final int SIZE = 10;

    // Array of linked list nodes to store key-value pairs
    private Node[] table;

    // Constructor: initialize the hash table array
    public VehicleHashTable() {
        table = new Node[SIZE];
    }

    // Inner class representing a key-value pair (node in linked list)
    private static class Node {
        String key;        // The key, like "Colombo"
        VehicleFleetTracking value;     // The value (VehicleFleetTracking object)
        Node next;         // Link to the next node in case of a collision

        // Constructor for the Node
        public Node(String key, VehicleFleetTracking value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Hash function: converts a string key into an index (0 to SIZE-1)
    private int hash(String key) {
        int hash = 0;
        // Simple hash: add ASCII values of each character
        for (char c : key.toCharArray()) {
            hash += c;
        }
        return hash % SIZE; // Limit index to array size
    }

    // Method to insert or update a vehicle using a region key
    public void put(String key, VehicleFleetTracking v2) {
        int index = hash(key);     // Get the index from the hash function
        Node head = table[index];  // Get the linked list at that index

        // Traverse the list to see if key already exists (update case)
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = v2; // Update value
                return;
            }
            current = current.next;
        }

        // If key does not exist, insert a new node at the beginning
        Node newNode = new Node(key, v2);
        newNode.next = head; // Point new node to old head (chain)
        table[index] = newNode; // Set new node as the new head
    }

    // Method to retrieve a vehicle by its region key
    public VehicleFleetTracking get(String key) {
        int index = hash(key);        // Get the index using hash function
        Node current = table[index];  // Get the linked list at that index

        // Traverse the list and find the node with the matching key
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value; // Return the found vehicle
            }
            current = current.next;
        }

        return null; // Return null if the key was not found
    }
}
