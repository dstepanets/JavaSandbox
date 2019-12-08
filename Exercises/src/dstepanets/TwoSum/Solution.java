package dstepanets.TwoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {

	public int[] twoSum(int[] nums, int target) {
		int[] solution = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer k = target - nums[i];
			if (map.containsKey(k)) {
				solution[0] = map.get(k);
				solution[1] = i;
				return solution;
			}
			map.put(nums[i], i);
		}
		return solution;
	}

}
