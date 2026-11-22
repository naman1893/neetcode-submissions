class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        if(n<2) return new int[]{};
        int start=0,end=n-1;
        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum==target){
                return new int[]{start+1,end+1};
            }
            else if (sum>target){
                end--;
            }else {
                start++;
            }
        }
        
        return new int[]{};
    }
}
