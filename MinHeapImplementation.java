import java.util.ArrayList;
import java.util.Collections;

class Main {
    static ArrayList<Integer> heap;

    public static void MinHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new element
    public static void insert(int val) {
        heap.add(val);
        int current = heap.size() - 1;

        // Heapify up
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap.get(current) < heap.get(parent)) {
                Collections.swap(heap, current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    // Remove and return the minimum element
    public static int remove() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // Heapify down after removal
    private static void heapifyDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;

        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            heapifyDown(smallest);
        }
    }

    // Display the heap
    public static void display() {
        System.out.println("Heap: " + heap);
    }
    public static  void main (String[] args) {
        MinHeap();
        insert(1);
        insert(3);
        insert(2);
        insert(4);
        insert(5);
        remove();
        remove();
        display();
    }
}
