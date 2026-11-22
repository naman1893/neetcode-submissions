class Solution {

    public static boolean checkSum(int []nums,int sum,int index){
        if(index==0)
            if(sum==0) return true;
            else return false;
        if(index<0||sum<0) 
            return false;
        if(nums[index]>sum)
            return checkSum(nums, sum,index-1);
        else 
            return checkSum(nums,sum,index-1)||checkSum(nums,sum-nums[index],index-1);
    }

    public boolean canPartition(int[] nums) {
        int totalSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        if(totalSum%2!=0) return false;
        return checkSum(nums,totalSum/2,n-1);
    }
}
