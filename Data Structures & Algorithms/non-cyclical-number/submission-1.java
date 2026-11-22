class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>hash= new HashSet<>();
        int number =n;
        while(!hash.contains(number)){
            hash.add(number);
            int sum=0;
            while(number!=0){
                int digit = number % 10;
                sum += digit * digit;
                number /= 10;
            }
            System.out.println(sum);
            number=sum;
            if(number==1)
                return true;
        }
        return false;
    }
}
