class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindrome (center is character at i)
            int len1 = expandAroundCenter(s, i, i);
            
            // Case 2: Even-length palindrome (center is between i and i + 1)
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // If a longer palindrome is found, update start and end indices
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expand outward as long as pointers are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length of palindrome is (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }
}