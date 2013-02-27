import java.util.Random;
import java.io.*;
import java.util.*;


class Utils {
    /*
     * Generate a random integer array with the size defined by length
     * Return: an integer array
     */
    public static int[] generateArray(int length) {
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
    public static int[] generateArray(int length, int limit) {
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
    public static void printArray(int[] arr) {
        for(int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
     * Read a list of integers from filePath, each integer is in one line
     * Return an integer array
     */
    public static int[] readIntArrayFromFile(String filePath) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        try {
            BufferedReader input =  new BufferedReader(new FileReader(filePath));
            String line = null;
            while( (line=input.readLine()) != null ) {
                numList.add(new Integer(line));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        int[] numArr = new int[numList.size()];
        Iterator<Integer> iterator = numList.iterator();
        for(int i=0; i<numList.size(); i++) {
            numArr[i] = iterator.next().intValue();
        }

        return numArr;
    }

    public static void main(String[] args) {
        int[] arr = generateArray(100);
        printArray(arr);
    }
}
