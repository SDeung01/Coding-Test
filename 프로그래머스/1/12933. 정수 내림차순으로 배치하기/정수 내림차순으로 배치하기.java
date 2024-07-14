import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long reverseNum = 0;
        String nToStr = String.valueOf(n);
        int[] nToArr = new int[nToStr.length()];
        
        for(int idx = 0; idx < nToStr.length(); idx++){
            nToArr[idx] = nToStr.charAt(idx) - '0';
        }
        
        Arrays.sort(nToArr);
        
        for(int idx = 0; idx < nToArr.length; idx++){
            long digit = (long)Math.pow(10, idx);
            reverseNum += digit * nToArr[idx];            
        }
        
        return reverseNum;
    }
}