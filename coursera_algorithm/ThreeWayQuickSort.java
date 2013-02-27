
public class ThreeWayQuickSort {
    public static void sort(int[] arr, int left, int right) {
        if (right <= left)
            return;

        int i = left;
        int lt = left;
        int gt = right;
        int pivot = arr[left];

        while (i <= gt) {
            if (arr[i] < pivot) {
                int temp = arr[lt];
                arr[lt] = arr[i];
                arr[i] = temp;
                i++;
                lt++;
            } else if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[gt];
                arr[gt] = temp;
                gt--;
            } else
                i++;
        }

        sort(arr, left, lt-1);
        sort(arr, gt+1, right);
    }

    public static void main(String[] args) {
        int[] iarr = Utils.generateArray(100, 1000);
        System.out.println("Initial array:");
        Utils.printArray(iarr);

        sort(iarr, 0, iarr.length-1);

        System.out.println("Sorted array:");
        Utils.printArray(iarr);
    }
}
