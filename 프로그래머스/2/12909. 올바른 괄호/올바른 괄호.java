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
        
//         int shift = 0;
//         int left = 0, right = 0;
//         char prevBracket = '(';

//         if(!s.startsWith("(") || !s.endsWith(")")) { return false; }
//         else {
//             for(int i = 0; i < s.length(); i++){
//                 char nowBracket = s.charAt(i);
//                 if(nowBracket == '(') left++;
//                 else if(nowBracket == ')') right++;
//                 if(nowBracket != prevBracket){
//                     shift++;
//                     if(shift % 2 == 0 && left != right+1){
//                         return false;
//                     }
//                 }
//                 prevBracket = nowBracket;
//             }
//         }

    }
}