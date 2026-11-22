class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        if (intervals.length == 0) return new int[0][];
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            if(ans.get(ans.size()-1)[1]>=start){
                ans.get(ans.size()-1)[1]=Math.max(intervals[i][1],ans.get(ans.size()-1)[1]);
            }
            else{
                ans.add(intervals[i]);
            }
        }
       return ans.toArray(new int[ans.size()][]);
    }
}
