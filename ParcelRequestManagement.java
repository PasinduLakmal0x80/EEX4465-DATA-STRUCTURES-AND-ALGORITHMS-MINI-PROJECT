import java.time.LocalDate;

public class ParcelRequestManagement {

    // prioritizing areas (same-day delivery < VIP customers < Timestamp <Deadline (timestamp))
    // request details (parcel ID, delivery location, deadline (timestamp), and time of order. )
    int parcelID;
    String deliveryLocation;
    LocalDate deadline;
    LocalDate orderTime;
    boolean isVIP;

    // Constructor to initialize the parcel request
    public ParcelRequestManagement(int parcelID, String deliveryLocation, LocalDate deadline, LocalDate orderTime, boolean isVIP) {
        this.parcelID = parcelID;
        this.deliveryLocation = deliveryLocation;
        this.deadline = deadline;
        this.orderTime = orderTime;
        this.isVIP = isVIP;
    }

    // compares this parcel (this) to another (other) for priority.
    public int compareTo(ParcelRequestManagement other){
        boolean thisSameDay = this.deadline.equals(LocalDate.now());
        boolean otherSameDay = other.deadline.equals(LocalDate.now());

        if (thisSameDay && !otherSameDay) return 1;
        if (!thisSameDay && otherSameDay) return -1;

        if (this.isVIP && !other.isVIP) return 1;
        if (!this.isVIP && other.isVIP) return -1;

        int orderCmp = this.orderTime.compareTo(other.orderTime);
        if (orderCmp != 0) return -orderCmp;

        int deadlineCmp = this.deadline.compareTo(other.deadline);
        if (deadlineCmp != 0) return -deadlineCmp;

        return Integer.compare(other.parcelID, this.parcelID);
    }

    public String toString() {
    return "Parcel{" + "ID=" + parcelID + ", location='" + deliveryLocation + '\'' +
            ", deadline=" + deadline + ", orderTime=" + orderTime + ", VIP=" + isVIP + '}';
    }
}