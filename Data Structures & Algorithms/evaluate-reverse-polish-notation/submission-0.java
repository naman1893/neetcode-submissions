class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int second = st.pop();
                int first = st.pop();
                if (tokens[i].equals("+")) {
                    st.push(first + second);
                }
                if (tokens[i].equals("-")) {
                    st.push(first - second);
                }
                if (tokens[i].equals("*")) {
                    st.push(first * second);
                }
                if (tokens[i].equals("/")) {
                    st.push(first / second);
                }
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}
