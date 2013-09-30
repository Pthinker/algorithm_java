import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Dynamically maintain the median of a list of integers
 */
public class MedianMaintenance {
    public static void main(String[] args) {
        int[] numbers = Utils.readIntArrayFromFile("data/Median.txt");
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // root is the minimum
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new MaxComparator()); // root is the maximum

        int sum = numbers[0];

        if (numbers[0] < numbers[1]) {
            maxHeap.add(numbers[0]);
            minHeap.add(numbers[1]);
            sum += numbers[0];
        } else {
            maxHeap.add(numbers[1]);
            minHeap.add(numbers[0]);
            sum += numbers[1];
        }

        for (int index=2; index<numbers.length; index++) {
            if (numbers[index] > maxHeap.peek()) {
                minHeap.add(numbers[index]);
                if ((minHeap.size()-maxHeap.size())>1) {
                    maxHeap.add(minHeap.poll());
                }
            } else {
                maxHeap.add(numbers[index]);
                if ((maxHeap.size()-minHeap.size())>1) {
                    minHeap.add(maxHeap.poll());
                }
            }

            if (maxHeap.size() >= minHeap.size())
                sum += maxHeap.peek();
            else
                sum += minHeap.peek();
        }

        System.out.println(sum%numbers.length);
    }
}

class MaxComparator implements Comparator<Integer> {
    public int compare( Integer x, Integer y ) {
        return y-x;
    }
}
