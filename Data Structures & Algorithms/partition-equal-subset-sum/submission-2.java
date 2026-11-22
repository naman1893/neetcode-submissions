class Solution {
    // memo[idx][sum] = -1 unknown, 0 false, 1 true
    private int[][] memo;

    private boolean checkSum(int[] nums, int idx, int sum) {
        if (sum == 0) return true;      // found a subset
        if (idx < 0 || sum < 0) return false;

        if (memo[idx][sum] != -1)       // use memoized result
            return memo[idx][sum] == 1;

        boolean take = sum >= nums[idx] && checkSum(nums, idx - 1, sum - nums[idx]);
        boolean skip = checkSum(nums, idx - 1, sum);

        boolean ans = take || skip;
        memo[idx][sum] = ans ? 1 : 0;   // memoize
        return ans;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        if ((total & 1) == 1) return false;   // odd sum can't be partitioned

        int target = total / 2;
        memo = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) Arrays.fill(memo[i], -1);

        return checkSum(nums, nums.length - 1, target);
    }
}
