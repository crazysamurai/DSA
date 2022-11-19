class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> hs = new HashSet<>();
        
        int len = wordList.size();
        for(int i = 0; i<len; i++){
            hs.add(wordList.get(i));
        }

        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord) == true) return steps;//if we already have the target word then we don't need to continue
            for(int i = 0;i<word.length(); i++){//loop through each char of the word
                for(char ch = 'a'; ch<='z'; ch++){
                    char [] wordArr = word.toCharArray();
                    wordArr[i] = ch;//replacing the current char with one b/w 'a' & 'z'
                    String newWord = new String(wordArr); //convert the new word array into a string
                    if(hs.contains(newWord)){
                        hs.remove(newWord);//remove the word from hashset because we don't need it again
                        q.add(new Pair(newWord, steps+1));//add the new word to the queue along with the steps
                    }
                }
            }

        }
    return 0;//if it's not possible to reach the target word return 0
    }
}

class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}