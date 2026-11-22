class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer>mapi= new HashMap<>();
        for(int num:nums){
            if(mapi.containsKey(num)){
                return true;
            }
            mapi.put(num,1);
        }
        return false;
 
    }
}
