class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=1;
        for(int i=n-1;i>=0;i--){
            int number = digits[i]+carry;
            if(number/10!=1){
                digits[i]=number;
                return digits;
            }
            carry=1;
            digits[i]=number%10;
        }
        int []arr = new int[n+1];
        if(carry==1){
            arr[0]=carry;
        }
        for(int i=0;i<n;i++)
            arr[i+1]=digits[i];
        return arr;
    }
}
