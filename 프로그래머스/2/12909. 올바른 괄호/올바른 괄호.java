import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> bracketStk = new Stack<>();
        
        if(!s.startsWith("(") || !s.endsWith(")")) { return false; }
        
        for(int i = 0; i < s.length(); i++){
            char nowBracket = s.charAt(i);
            if(nowBracket == '(') { bracketStk.push('('); }
            if(bracketStk.isEmpty()) { return false; }
            if(nowBracket == ')') { bracketStk.pop(); }
        }
        
        return bracketStk.size() == 0 ? true : false;
    }
}