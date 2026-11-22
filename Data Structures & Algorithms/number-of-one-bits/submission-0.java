class Solution {
    public int hammingWeight(int n) {
        int total=0;
        while(n!=0){
            total+=n%2;
            n=n/2;
        }
        return total;
    }
}
