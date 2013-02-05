/*
 * My solution to https://class.coursera.org/algo-003/quiz/attempt?quiz_id=31
 * This class compute the number of inversions in the file of a list of integers
 */

import java.io.*;
import java.util.*;


public class InversionCount {
    public static void main(String args[]) {
        String filePath = "data/IntegerArray.txt";
        
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

        long num = count(numArr, 0, numArr.length-1);
        System.out.println("Number of inversion: " + num);
    }

    private static long count(int[] arr, int begin, int end) {
        if( (end-begin+1)==1 )
            return 0;

        int middle = begin + (end-begin+1)/2;

        long leftCount = count(arr, begin, middle-1);
        long rightCount = count(arr, middle, end);
        long  mixCount = mergeCount(arr, begin, end);

        return leftCount + rightCount + mixCount;
    }

    private static long mergeCount(int[] arr, int begin, int end) {
        int middle = begin + (end-begin+1)/2;
        int length = end-begin+1;

        int[] temp = new int[length];

        int leftPointer = begin;
        int rightPointer = middle;
        long invert = 0;

        for(int i=0; i<length; i++) {
            if(leftPointer>=middle && rightPointer<=end) {
                temp[i] = arr[rightPointer];
                rightPointer++;
            } else if( rightPointer>end && leftPointer<middle ) {
                temp[i] = arr[leftPointer];
                leftPointer++;
            } else if(rightPointer<=end && leftPointer<middle) { 
                if(arr[leftPointer]<=arr[rightPointer]) {
                    temp[i] = arr[leftPointer];
                    leftPointer++;
                } else {
                    temp[i] = arr[rightPointer];
                    rightPointer++;
                    invert += (middle-leftPointer);
                }
            }
        }

        // copy temp back
        for(int i=0; i<length; i++) {
            arr[begin+i] = temp[i];
        }

        return invert;
    }
}
