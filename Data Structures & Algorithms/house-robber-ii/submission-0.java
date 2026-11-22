class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int memo[] = new int[nums.length-1];
        memo[0]=nums[0];
        memo[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            memo[i]=Math.max(nums[i]+memo[i-2],memo[i-1]);
        }
        int memo2[] = new int [n-1];
        memo2[0]=nums[1];
        memo2[1]=Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            memo2[i-1]=Math.max(nums[i]+memo2[i-3],memo2[i-2]);
        }
        return Math.max(memo2[n-2],Math.max(memo[n-2],Math.max(memo[n-3],memo2[n-3])));

    }
}
