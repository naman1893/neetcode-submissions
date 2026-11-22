class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Pair<Integer, Integer>> st = new Stack();
         int[] res = new int[temperatures.length];
        
       for (int i = temperatures.length - 1; i >= 0; i--) {
        int curtemp = temperatures[i];
        while(!st.isEmpty() && st.peek().getValue()<= curtemp) {
           st.pop();
            }
            if(!st.empty()){
                res[i] = st.peek().getKey() -i;
            }
            else{
                res[i] = 0;
            }
        st.push(new Pair<>(i, curtemp));
       }

       return res;

    }  
} 