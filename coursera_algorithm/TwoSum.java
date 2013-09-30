import java.util.HashMap;

/*
 * Two SUM problem using a hash
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = Utils.readIntArrayFromFile("data/HashInt.txt");
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

        for (int i : numbers) {
            table.put(i, 1);
        }

        int count = 0;
        for (int sum=2500; sum<=4000; sum++) {
            boolean found = false;
            for (int index=0; index<numbers.length; index++) {
                if (table.containsKey(sum-numbers[index]) && ((sum-numbers[index]) != numbers[index])) {
                    found = true;
                    break;
                }
            }
            if (found)
                count++;
        }

        System.out.println(count);
    }
}
