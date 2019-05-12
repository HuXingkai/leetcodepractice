package com.company.MedianofTwoSortedArrays;

public class MedianOfArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=0, p = 0;
        int n = nums1.length - 1;
        int q = nums2.length - 1;
        if (n<0) return getMedian(nums2, p, q);
        if (q<0) return getMedian(nums1, m, n);
        return findMedianByMixedArrays(nums1, m, n, nums2, p, q);
    }

    /**
     * 利用递归的方法，将有重叠的两个数组按照各自的中位数划分，直到他们之间没有重叠，利用没用重叠的两数组求中位数的方法求中位数
     * @param nums1
     * @param begin1
     * @param end1
     * @param nums2
     * @param begin2
     * @param end2
     * @return
     */
    public double findMedianByMixedArrays(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2) {
        if (!(nums1[begin1] > nums2[end2] || nums1[end1] < nums2[begin2])) {
            double a = getMedian(nums1, begin1, end1);
            double b = getMedian(nums2, begin2, end2);
            if (a < b) {
                return findMedianByMixedArrays(nums1, (begin1 + end1) / 2 + (begin1<end1?1:0), end1, nums2, begin2, (begin2 + end2) / 2);
            }
            else if (a > b) {
                return findMedianByMixedArrays(nums1, begin1, (begin1 + end1) / 2, nums2, (begin2 + end2) / 2+(begin2<end2?1:0), end2);
            } else return getMedian(nums1, begin1, end1);
        } else return findMedianByRegularArrays(nums1, begin1, end1, nums2, begin2, end2);
    }

    /**
     * 获取一个单一数组的中位数
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public double getMedian(int[] nums, int i, int j) {
        int mid = (i + j) / 2;
        if (((i + j) % 2) != 0) {
            return ((double)nums[mid]+(double)nums[mid+1]) / 2;
        } else return nums[mid];
    }

    /**
     * 此方法用于求两个不存在交集的子数组的中位数
     * @param nums1 数组1
     * @param begin1 数组1的子数组开始位置
     * @param end1   数组1的子数组结束位置
     * @param nums2
     * @param begin2
     * @param end2
     * @return
     */
    public double findMedianByRegularArrays(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2) {

        //flag=true,表明num1>nums2
        boolean flag = true;
        double answer=-1;
        //判断数组的大小，将两个数组拼接之后，小值数组在左
        if (nums1[begin1]<=nums2[end2]) {
            flag = false;
        }
        int length1 = end1 - begin1 + 1;
        int length2 = end2 - begin2 + 1;

        int mid = (length1+length2) / 2;
        if ((length1 + length2) % 2 == 0) {
            if (flag) {
                answer = giveAnswer(nums1, begin1, nums2, begin2, end2, mid, length2);
            } else {
                answer = giveAnswer(nums2, begin2, nums1, begin1, end1, mid, length1);
            }
        } else {
            if (flag) {
                answer = (begin2 + mid) <= end2 ? nums2[begin2 + mid] : nums1[begin1 + mid - length2];
            } else {
                answer = (begin1 + mid) <= end1 ? nums1[begin1 + mid] : nums2[begin2 + mid - length1];
            }
        }
        return answer;
    }

    public double giveAnswer(int[] Max, int begin1, int[] min, int begin2, int end2, int mid,int length) {
        double a = (begin2 + mid - 1) <= end2 ? min[begin2 + mid - 1] : Max[begin1 + mid - 1 - length];
        double b = (begin2 + mid) <= end2 ? min[begin2 + mid] : Max[begin1 + mid - length];
        return  (a + b) / 2;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6};
        int[] b = {3 ,4};
        MedianOfArrays m = new MedianOfArrays();
        //System.out.println(m.findMedianByRegularArrays(a,0,2,b,0,1));
        System.out.println(m.findMedianSortedArrays(a,b));
        //System.out.println(m.getMedian(a,0,3));
    }
}
