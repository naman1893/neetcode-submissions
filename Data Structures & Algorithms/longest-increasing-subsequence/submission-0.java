class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length];
        lis[0]=1;
        for(int i=1;i<nums.length;i++){
            lis[i]=1;
            for(int j=i;j>=0;j--){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=Math.max(lis[i],ans);
        }
        return ans;
    }
}
