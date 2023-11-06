import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int speak = 0;
        String prevWord = "" + words[0].charAt(0);
        Set<String> wordSet = new HashSet<>();
        
        for(String myWord : words){
            int playerNo = (speak % n) + 1;
            int turn = (speak / n) + 1;
            
            if(chainCheck(prevWord, myWord) && dupliCheck(wordSet, myWord)){
                prevWord = myWord;
                wordSet.add(myWord);
                speak++;
            } else {
                return new int[]{playerNo, turn};
            }
        }
        return new int[]{0, 0};
    }
    
    private boolean chainCheck(String prevWord, String myWord){
        char lastCh = prevWord.charAt(prevWord.length()-1);
        char startCh = myWord.charAt(0);
        return lastCh == startCh;
    }
    
    private boolean dupliCheck(Set<String> wordSet, String myWord){
        return !wordSet.contains(myWord);
    }
}