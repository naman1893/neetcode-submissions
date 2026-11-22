class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end =0;
        int maxi=0;
        int arr[]= new int[128];
        while(end<s.length()){
            if(arr[s.charAt(end)]!=0){
                while(start<end){
                    if(s.charAt(end)!=s.charAt(start)){
                        arr[s.charAt(start)]--;
                        start++;
                    }else{
                        arr[s.charAt(start)]--;
                        start++;
                        break;
                    }
                }
            }
            arr[s.charAt(end)]++;
            end++;
            maxi=Math.max(maxi,end-start);
        }
        return maxi;
        
    }
}
