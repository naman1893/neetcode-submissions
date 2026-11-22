class Solution {
    static class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.second-a.second);
        HashMap<Integer,Integer>mapi=new HashMap<>();
        for( int i=0;i<nums.length;i++){
            mapi.put(nums[i],mapi.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:mapi.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.peek().first;
            pq.remove();
        }
        return ans;
    }
}
