class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seti = new HashSet<>();
        for(int i:nums){
            if(!seti.contains(i)){
                seti.add(i);
            }
            else 
                return true;
        }       
        return false; 
    }
}