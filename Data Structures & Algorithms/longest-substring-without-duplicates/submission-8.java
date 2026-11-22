class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end =0;
        int maxi=0;
        int arr[]= new int[128];
        while(end<s.length()){
            while(arr[s.charAt(end)]>0){
                
                    arr[s.charAt(start)]--;
                    start++;
            }
            arr[s.charAt(end)]++;
            end++;
            maxi=Math.max(maxi,end-start);
        }
        return maxi;
        
    }
}
