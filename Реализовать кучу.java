import java.util.Scanner;

class MaxHeap {
    private int[] heap;
    private int size;
    private static final int INITIAL_CAPACITY = 100000;

    public MaxHeap() {
        heap = new int[INITIAL_CAPACITY];
        size = 0;
    }
    public void insert(int value) {
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }
    public int extractMax() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] > heap[parent]) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }
    private void heapifyDown(int index) {
        while (index * 2 + 1 < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MaxHeap maxHeap = new MaxHeap();

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            if (command == 0) {
                int value = scanner.nextInt();
                maxHeap.insert(value);
            } else if (command == 1) {
                System.out.println(maxHeap.extractMax());
            }
        }
    }
}
