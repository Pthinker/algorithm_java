import java.util.Random;


class MergeSort {
    public static void main (String[] args) {
        
        /*
        final int LENGTH = 100;
        Random rand = new Random();
        int[] iarr = new int[LENGTH];
        for (int i = 0; i < iarr.length; i++) {
            //iarr[i] = rand.nextInt(99999999);
        }
        */

        int[] iarr = {51, 13, 25, 73, 59, 53, 81, 92, 64, 39, 33, 38};

        //System.out.println("Initial array:");
        //displayArray(iarr, 0, iarr.length-1);

        int[] aux = new int[iarr.length]; // make an auxiliar array to improve speed
        mergesort(iarr, aux, 0, iarr.length-1);

        //System.out.println("Sorted Array:");
        //displayArray(iarr, 0, iarr.length-1);
    }

    private static void mergesort(int[] data, int[] aux, int begin, int end) {
        if (end <= begin)
            return;
        
        int middle = begin + (end - begin) / 2;
        mergesort(data, aux, begin, middle);
        mergesort(data, aux,  middle+1, end);
  
        merge(data, aux, begin, middle, end);
        displayArray(data, 0, data.length-1);

    }

    private static void merge(int[] data, int[] aux, int begin, int middle, int end) {
        //copy to auxiliar array
        for (int k = begin; k <= end; k++)
            aux[k] = data[k];

        int i = begin;
        int j = middle + 1;

        for (int k = begin; k <= end; k++) {
            if (i > middle)
                data[k] = aux[j++];
            else if (j > end)
                data[k] = aux[i++];
            else if (aux[j] < aux[i])
                data[k] = aux[j++];
            else
                data[k] = aux[i++];
        }
    }

    private static void displayArray(int[] data, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

