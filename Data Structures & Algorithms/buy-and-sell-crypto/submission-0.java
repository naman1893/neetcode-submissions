class Solution {
    public int maxProfit(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();
        int n=prices.length;
        int maximumValue=0;
        for(int i=n-1;i>=0;i--){
            maximumValue=Math.max(prices[i],maximumValue);
            list.add(maximumValue);
        }

        // 10 1 5 6 7 1 
        // 1 7 7 7 7 10
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,list.get(n-1-i)-prices[i]);
        }
        return ans;

        
    }
}
