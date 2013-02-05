import java.util.Random;


class MergeSort {
  public static void main(String[] args) {
    final int LENGTH = 100;

    Random rand = new Random();
    int[] iarr = new int[LENGTH];
    int i;

    System.out.println("Initial array:");
    for(i=0; i<LENGTH; i++) {
      int fraction = (int)(200 * rand.nextDouble());
      int randomNumber =  (int)(fraction + 0);
      iarr[i] = randomNumber;
      System.out.print(iarr[i] + " ");
    }
    System.out.println();

    mergesort(iarr, 0, LENGTH-1);

    System.out.println("Sorted Array:");
    for( i=0; i<LENGTH; ++i ) {
      System.out.print(iarr[i] + " ");
    }
    System.out.println();
  }

  private static void mergesort(int[] data, int start, int end) {
    int middle;
    int length = end-start+1;
    if(length>1) {
      middle = start + length/2 - 1;
      mergesort(data, start, middle);
      mergesort(data, middle+1, end);
  
      merge(data, start, middle, middle+1, end);
    }
  }

  private static void merge(int[] data, int start1, int end1, int start2, int end2) {
    int length1 = end1 - start1 + 1;
    int length2 = end2 - start2 + 1;
    int[] temp = new int[length1+length2];

    int copied = 0;
    int flag1 = start1;
    int flag2 = start2;
    int i;

    while( (flag1<=end1) && (flag2<=end2) ) {
      if( data[flag1]<data[flag2] ) {
        temp[copied] = data[flag1];
        copied++;
        flag1++;
      } else {
        temp[copied] = data[flag2];
        copied++;
        flag2++;
      }
    }
     
    while( flag1<=end1 ) {
      temp[copied] = data[flag1];
      copied++;
      flag1++;
    }
 
    while( flag2<=end2 ) {
      temp[copied] = data[flag2];
      copied++;
      flag2++;
    }
 
    //copy from temp back to data
    for(i=0; i<(length1+length2); i++) {
      data[start1+i] = temp[i];
    }
  }

  private static void displayArray(int[] data, int start, int end) {
    int i;
    for(i=start; i<=end; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }
}
