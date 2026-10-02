class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];               // Copy forward order to first half
            ans[i + n] = nums[n - 1 - i];   // Copy reverse order to second half
        }

        return ans;
    }
}