
class Pair{
    int first;
    int second;

    Pair(int a, int b){
        this.first=a;
        this.second=b;
    }
}

class MinStack {
    Stack<Pair>st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.push(new Pair(val,val));
        }else{
            if(st.peek().second<val){
                st.push( new Pair(val,st.peek().second));
            }else{
                st.push(new Pair(val,val));
            }
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().first;
    }
    
    public int getMin() {
        return st.peek().second;
    }
}
