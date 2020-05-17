package dstepanets.wix.clock;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

	private Integer[] time;
	private int validTimes = 0;
	private final ArrayList<Integer[]> list = new ArrayList<>();

	private boolean validateTime() {
		if (time[0] > 2 || time[2] > 5)
			return false;
		if ((time[0] * 10 + time[1]) > 23)
			return false;
		return !isInTheList(time);
	}

	private boolean isInTheList(Integer[] t) {
		for (Integer[] a : list) {
			if (Arrays.equals(a, t))
				return true;
		}
		return false;
	}

	private void generatePermutations(int n) {
		if (n == 1 && validateTime()) {
			printTime();
			list.add(time.clone());
			validTimes++;
		}
		for (int i = 0; i < n; i++) {
			generatePermutations(n - 1);
//			If size is even, swap ith and the last
			if (n % 2 == 0) {
				swap(i, n - 1);
//			if size is odd, swap first and last
			} else {
				swap(0, n - 1);
			}
		}
	}

	private void swap(int a, int b) {
		int tmp = time[a];
		time[a] = time[b];
		time[b] = tmp;
	}

	public int solution(int A, int B, int C, int D) {

		time = new Integer[4];
		time[0] = A;
		time[1] = B;
		time[2] = C;
		time[3] = D;

		generatePermutations(4);

		return validTimes;
	}

	private void printTime() {
		System.out.println(time[0] + "" + time[1] + ":" + time[2] + "" + time[3]);
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		solution.solution(2, 3, 1, 8);
		System.out.println(solution.validTimes);

	}
}

