//TLE on gfg, passes on lc
class Solution {
    public String minWindow(String s, String t) {
        
        String ans = new String();
        
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        
        int mct = 0; //match count
        int dmct = t.length(); //desired mct
        
        Map<Character, Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            //acquire
            while(i<s.length()-1 && mct<dmct){
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0)+1);
                
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)) mct++;
                flag1 = true;
            }
            
            //release
            while(j<i && mct==dmct){
                String res = s.substring(j+1, i+1);
                if(ans.length()==0 || res.length()<ans.length()) ans = res;
                j++;
                
                char ch = s.charAt(j);
                
                if(map1.get(ch) == 1)map1.remove(ch);
                else map1.put(ch, map1.get(ch)-1);
                
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) mct--;
                
                flag2 = true;
            }
            
            if(flag1 == false && flag2 == false) break; 
        }
        return ans;
    }
}