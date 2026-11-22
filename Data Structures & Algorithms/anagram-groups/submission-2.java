class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        for(String str:strs){
            int count[] = new int[26];
            for(int i=0;i<str.length();i++){
                count[str.charAt(i)-'a']++;
            }

            String s="";
            for(int i=0;i<26;i++){
                s+='#'+count[i];
            }
            if(!map.containsKey(s))
                map.put(s,new ArrayList<>());
            map.get(s).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
