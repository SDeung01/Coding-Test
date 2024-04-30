import java.lang.Math;
import java.util.*;

class Solution {
    public int solution(int n) {
        int quotient = n;
        int reverseThreeToTen = 0;
        
        Stack<Integer> reverseThree = new Stack<>();
        
        while(quotient >= 3 ){
            reverseThree.push(quotient % 3);
            quotient = quotient/3;
        }
        
        reverseThree.push(quotient);
        
        int stackSize = reverseThree.size();
        
        for(int square = 0; square < stackSize; square++){
            reverseThreeToTen += reverseThree.pop() * (int) Math.pow(3,square);
        }
        
        return reverseThreeToTen;
    }
}