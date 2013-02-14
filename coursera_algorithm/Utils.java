import java.util.Random;


class Utils {
    /*
     * Generate a random integer array with the size defined by length
     * Return: an integer array
     */
    public static int[] generate_array(int length) {
        Random rand = new Random();
        int[] iarr = new int[length];
        int i;

        for(i=0; i<length; i++) {
            int randNum = rand.nextInt();
            iarr[i] = randNum;
        }
        return iarr;
    }

    /*
     * Generate a random integer array with the size defined by length
     * Return: an integer array that every element is less than limit
     */
    public static int[] generate_array(int length, int limit) {
        Random rand = new Random();
        int[] iarr = new int[length];
        int i;

        for(i=0; i<length; i++) {
            int randNum = rand.nextInt(limit);
            iarr[i] = randNum;
        }
        return iarr;
    }

    /*
     * Output an integer array
     */
    public static void print_array(int[] arr) {
        for(int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generate_array(100);
        print_array(arr);
    }
}
