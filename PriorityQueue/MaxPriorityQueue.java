package PriorityQueue;

import java.util.*;

public class MaxPriorityQueue {
    int size;
    ArrayList<Integer> heap;

    public MaxPriorityQueue() {
        heap = new ArrayList<>();
    }

    int size() {
        return size;
    }

    boolean IsEmpty() {
        return size == 0;
    }

    int getmax() {
        return heap.get(0);
    }

    public void insert(int elem) {
        size++;
        heap.add(elem);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public int RemoveMax() {
        size--;
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        int index = 0;
        int maxindex = index;
        int leftchildIndex = 1;
        int rightchildIndex = 2;
        while (leftchildIndex < heap.size()) {
            if (heap.get(maxindex) < heap.get(leftchildIndex)) {
                maxindex = leftchildIndex;
            }
            if (rightchildIndex < heap.size() && heap.get(maxindex) < heap.get(rightchildIndex)) {
                maxindex = rightchildIndex;
            }
            if (maxindex == index) {
                break;
            } else {
                int temp1 = heap.get(index);
                heap.set(index, heap.get(maxindex));
                heap.set(maxindex, temp1);
                index = maxindex;
                leftchildIndex = (2 * maxindex) + 1;
                rightchildIndex = (2 * maxindex) + 2;
            }
        }
        return temp;
    }
}
    class MinPriorityQueuetest
    {
        public static void main(String[] args) {
            int arr[] = {30,22,25,20,21,19,18};
            MaxPriorityQueue pq = new MaxPriorityQueue();
            for(int i : arr)
            {
                pq.insert(i);
            }
            while(!pq.IsEmpty())
            {
              System.out.println(pq.RemoveMax());
            }
        }
    }
