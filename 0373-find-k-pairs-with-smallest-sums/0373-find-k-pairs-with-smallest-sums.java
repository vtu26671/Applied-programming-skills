import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Priority Queue stores arrays of [sum, index_in_nums1, index_in_nums2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize heap with (nums1[i] + nums2[0]) for the first k elements of nums1
        // We only need up to k elements because we only need k total pairs
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract the smallest sum and push the next possible pair from nums2
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there's a next element in nums2 for the current nums1[i], add it to heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }
}