class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxKadane = nums[0];
        int currentMax = 0;

        int minKadane = nums[0];
        int currentMin = 0;

        for (int num : nums) {
            // Max subarray (Kadane)
            currentMax = Math.max(num, currentMax + num);
            maxKadane = Math.max(maxKadane, currentMax);

            // Min subarray (Kadane variant)
            currentMin = Math.min(num, currentMin + num);
            minKadane = Math.min(minKadane, currentMin);

            totalSum += num;
        }

        // If all numbers are negative
        if (maxKadane < 0) {
            return maxKadane;
        }

        // Max of normal vs circular
        return Math.max(maxKadane, totalSum - minKadane);
    }
}