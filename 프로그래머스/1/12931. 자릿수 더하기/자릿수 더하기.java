import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String nToStr = String.valueOf(n);
        char[] nToCharArr = nToStr.toCharArray();
        
        for(char ch : nToCharArr){
            answer += ch - 48;
        }

        return answer;
    }
}