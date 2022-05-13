class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> hm = new HashMap<>();
        
        if(strs == null || strs.length == 0) return Collections.emptyList();
         
        for(String s : strs){
            char freqArr [] = new char[26]; //creating a frequency array to store the frequency of each char in each string
            for(int i = 0; i<s.length(); i++){
                int idx = s.charAt(i) - 'a'; // ascii val of the resp char - ascii val of a will give us the idx in the freq array, a-a = 0 ... z-a = 25
                freqArr[idx]++;
            }

            String key = new String(freqArr); //converting freq arr into a string to store it as a key
            
            List<String> value = hm.getOrDefault(key, new ArrayList<String>());
            value.add(s);
            hm.put(key, value);
        }
        return new ArrayList<>(hm.values());
    }
}
