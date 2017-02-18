170. Two Sum III - Data structure design

Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false


import java.util.Map;
import java.util.HashMap;


public class Two_Sum_III {
	private Map<Integer, Integer> data = new HashMap<Integer, Integer>();

	public void add(int number) {
		if(data.containsKey(number)) {
			data.put(number, data.get(number)+1);
		} else {
			data.put(number, 1);
		}
	}

	public boolean find(int number) {
		for(Integer i : data.keySet()) {
			int target = number - i;
			if(data.containsKey(target)) {
				if(i==target && data.get(target) < 2) {
					return false;
				}
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Two_Sum_III util = new Two_Sum_III();
		util.add(1);
		util.add(3);
		util.add(5);
		
		System.out.println(util.find(4));
		System.out.println(util.find(7));
	}
}
