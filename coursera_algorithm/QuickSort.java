
public class QuickSort {

    public static void quicksort(int[] arr, int left, int right) {
        if (right <= left)
            return;

        int pivot = arr[left];
        int index = left+1;

        for(int i=left+1; i<=right; ++i) {
            if(arr[i]<pivot) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index+=1;
            }
        }
        int temp = arr[index-1];
        arr[index-1] = arr[left];
        arr[left] = temp;

        quicksort(arr, left, index-2);
        quicksort(arr, index, right);
    }

    public static void main(String[] args) {
        int[] iarr = Utils.generateArray(1000, 2000);
        System.out.println("Initial array:");
        Utils.printArray(iarr);

        quicksort(iarr, 0, iarr.length-1);

        System.out.println("Sorted array:");
        Utils.printArray(iarr);
    }
}
