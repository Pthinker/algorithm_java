/* Design an algorithm to rotate an array/string to the right by k positions
 * http://blog.csdn.net/v_july_v/article/details/6322882
 */

public class RotateArray {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', '1', '2', '3', '4'};
        int k = 3;

        System.out.println("Before: " + new String(arr));

        rotate(arr, k);

        System.out.println("After: " + new String(arr));
    }

    public static void rotate(char[] arr, int k) {
        k %= arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
    }

    public static void reverse(char[] arr, int left, int right) {
        while(left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
