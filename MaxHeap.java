import java.util.ArrayList;

        /*    Priority hierarchy:
        1. Same-day delivery (deadline is today)
        2. VIP customers (isVIP is true)
        3. Earlier orderTime (earlier timestamp)
        4. Earlier deadline (earlier timestamp)
        */
        
public class MaxHeap {
        private ArrayList<ParcelRequestManagement> heap = new ArrayList<>();

        public void insert(ParcelRequestManagement parcel) {
            heap.add(parcel);
            heapifyUp(heap.size() - 1);
        }

        public ParcelRequestManagement extractMax() {
            if (heap.isEmpty()) return null;

            ParcelRequestManagement max = heap.get(0);
            ParcelRequestManagement last = heap.remove(heap.size() - 1);
            if (!heap.isEmpty()) {
                heap.set(0, last);
                heapifyDown(0);
            }
            return max;
        }

        private void heapifyUp(int index) {
            while (index > 0) {
                int parentIdx = (index - 1) / 2;
                if (heap.get(index).compareTo(heap.get(parentIdx)) > 0) {
                    swap(index, parentIdx);
                    index = parentIdx;
                } else break;
            }
        }

        private void heapifyDown(int index) {
            int size = heap.size();
            while (index < size) {
                int largest = index;
                int left = 2 * index + 1;
                int right = 2 * index + 2;

                if (left < size && heap.get(left).compareTo(heap.get(largest)) > 0) {
                    largest = left;
                }
                if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0) {
                    largest = right;
                }

                if (largest != index) {
                    swap(index, largest);
                    index = largest;
                } else break;
            }
        }

        private void swap(int i, int j) {
            ParcelRequestManagement temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public void printHeap() {
            for (ParcelRequestManagement p : heap) {
                System.out.println(p);
            }
        }
    }