
public class QuickSortQuestion {

    public static long quicksort(int[] arr, int left, int right) {
        if( (right-left+1)<=1 )
            return 0;

        //int pivot = arr[left];
        //int pivot = arr[right];
        int length = right-left+1;
        int mid = left;
        if(length%2==0) {
            mid = left + (right-left+1)/2-1;
        } else {
            mid = left + (right-left+1)/2;
        }
        int pivot = arr[left];
        int pivotIndex = left;
        if(arr[left]>arr[mid]) {
            if(arr[mid]>arr[right]) {
                pivot = arr[mid];
                pivotIndex = mid;
            } else if(arr[left]>arr[right]) {
                pivot = arr[right];
                pivotIndex = right;
            } else {
                pivot = arr[left];
                pivotIndex = left;
            }
        } else {
            if(arr[mid]<arr[right]) {
                pivot = arr[mid];
                pivotIndex = mid;
            } else if(arr[left]<arr[right]) {
                pivot = arr[right];
                pivotIndex = right;
            } else {
                pivot = arr[left];
                pivotIndex = left;
            }
        }

        arr[pivotIndex] = arr[left];
        arr[left] = pivot;

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

        long count = right-left;
        return count + quicksort(arr, left, index-2) + quicksort(arr, index, right);
    }

    public static void main(String[] args) {
        //String fpath = "data/testcase3.txt";
        //String fpath = "data/IntegerArray.txt";
        String fpath = "data/QuickSort.txt";
        int[] iarr = Utils.readIntArrayFromFile(fpath);
    
        long count = quicksort(iarr, 0, iarr.length-1);

        System.out.println(count);
    }
}
