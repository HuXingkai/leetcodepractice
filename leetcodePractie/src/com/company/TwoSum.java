package com.company;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int j = 0; j < nums.length; j++) {
            int num = target - nums[j];
                if (list.contains(num)) {
                    arr[0] = j;
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] == num) {
                            arr[1] = k;
                        }
                    }
                    if (arr[0] < arr[1]) {
                        break;
                    }

                }
        }
        return arr;
    }


    /**
     * 利用哈希表，降低查询的时间复杂度
     */
    public int [] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(new TwoSum().twoSum1(nums,6)));
    }
}
