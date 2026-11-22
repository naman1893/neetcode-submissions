class Solution {
    public int longestConsecutive(int[] nums) {
     TreeSet<Integer> treeSet = new TreeSet<>();
     for(int i=0;i<nums.length;i++){
        treeSet.add(nums[i]);
     }
     int ans=0;
     int count=0;
     int number=-1000000002;
     for(Integer i:treeSet){
        if(i==number+1){
            count++;
        }
        else{
            ans=Math.max(count,ans);
            count=1;
        }
        number=i;
     }
     return Math.max(count,ans);
    }
}
