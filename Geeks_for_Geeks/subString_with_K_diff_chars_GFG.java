class Solution {
    int countSubstr(String s, int k) {
        return distinct(s,k) - distinct(s,k-1);
        
    }
        // your code here
    public static   int distinct(String s , int k){
            int l = 0,  count = 0;
            
            HashMap<Character,Integer> map = new HashMap<>();
            
        
        for(int i=0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch ,  map.getOrDefault(ch , 0) + 1);
            //   map.put(ch,map.getOrDefault(ch,0)+1);
        
        while(map.size() > k){
            map.put(s.charAt(l),map.get(s.charAt(l))-1);
            map.remove(s.charAt(l),0);
            l++;
        }
        count += i - l + 1;  
        }
        return count;
    }
}