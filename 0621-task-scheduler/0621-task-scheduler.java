import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Step 2: Sort to find the max frequency
        Arrays.sort(freq);
        int maxFreq = freq[25];
        
        // Step 3: Count how many tasks have that same max frequency
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                maxCount++;
            } else {
                break;
            }
        }

        // Step 4: Calculate the minimum intervals needed
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        // Return the maximum of the calculated result or the actual task length
        return Math.max(result, tasks.length);
    }
}