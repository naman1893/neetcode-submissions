class Solution {
    public boolean isPalindrome(String s) {
        String finalString ="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }else if (s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9){
               finalString+=s.charAt(i); 
            }else if (s.charAt(i)-'a'>=0&&s.charAt(i)-'a'<=25){
                finalString+=s.charAt(i); 
            }else if(s.charAt(i)-'A'>=0&&s.charAt(i)-'A'<=25) {
                finalString+=(char)(s.charAt(i)-'A'+'a'); 
            }else {
                continue;
            }
        }
        System.out.println(finalString);
        for(int i=0;i<finalString.length()/2;i++){
            if(finalString.charAt(i)!=finalString.charAt(finalString.length()-i-1)){
                return false;
            }
        }
        return true;
        
    }
}
