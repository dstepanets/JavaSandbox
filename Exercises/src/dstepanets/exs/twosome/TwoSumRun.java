package dstepanets.exs.twosome;

/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/

public class TwoSumRun {


    public static void main(String[] args) {

        int[] arr = {-11, 0, 898, 3, 2, 4, 1, -111};
        int target = 6;

        Solution solution = new Solution();
        int[] sol = solution.twoSum(arr, target);

        System.out.println(sol[0] + ", " + sol[1]);

    }



}
