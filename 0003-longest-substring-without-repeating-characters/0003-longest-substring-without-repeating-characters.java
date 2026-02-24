class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;

        java.util.HashSet<Character> set = new java.util.HashSet<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // Remove characters until no duplicate
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}