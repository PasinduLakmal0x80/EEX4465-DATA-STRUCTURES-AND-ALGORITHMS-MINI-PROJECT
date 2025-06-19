public class VehicleFleetTracking {
    // Maintain a list of available delivery vehicles

    int vehicleID;
    String currentLocation;
    int parcelCapacity;
    boolean status; // true for available, false for not available

    // Constructor to initialize the vehicle tracking details
    public VehicleFleetTracking(int vehicleID, String currentLocation, int parcelCapacity, boolean status) {
        this.vehicleID = vehicleID;
        this.currentLocation = currentLocation;
        this.parcelCapacity = parcelCapacity;
        this.status = status;
    }

    public String toString() {
        return "Vehicle{" + "ID=" + vehicleID + ", location='" + currentLocation + '\'' +
                ", capacity=" + parcelCapacity + ", status=" + (status ? "Available" : "Not Available") + '}';
    }

}
