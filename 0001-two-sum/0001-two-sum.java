import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store numbers and their corresponding index
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the required complement already exists in the map
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            
            // Otherwise, store current element and its index
            numMap.put(nums[i], i);
        }
        
        return new int[] {};
    }
}