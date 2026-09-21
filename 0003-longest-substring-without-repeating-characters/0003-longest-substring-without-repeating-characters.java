import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen inside the current window, move 'left' pointer
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            // Store / update the position of the character
            charMap.put(currentChar, right);

            // Calculate max window size seen so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}