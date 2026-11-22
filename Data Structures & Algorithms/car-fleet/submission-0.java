class Solution {

    private static class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>();
        Pair[]arr = new Pair[position.length];
        for(int i=0;i<position.length;i++){
            arr[i]=new Pair(position[i],speed[i]);
        }
        Arrays.sort(arr, (a, b) -> b.first - a.first);
        for(int i=0;i<arr.length;i++){
            double time = (double)(target - arr[i].first) / arr[i].second;
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        }
        return st.size();
    }
}
