import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build frequency map
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 2. Create buckets where index is frequency
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : count.keySet()) {
            int frequency = count.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        // 3. Gather the top k frequent elements
        int[] res = new int[k];
        int counter = 0;
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    res[counter++] = num;
                    if (counter == k) return res;
                }
            }
        }
        
        return res;
    }
}