class Solution {
    public int solution(String s) {
        int sToInt = 0;
        int sign = 1;
        
        if(s.startsWith("+") || s.startsWith("-")){
            sign = s.charAt(0) == '+' ? 1 : -1;
            s = s.substring(1);
        }
        
        sToInt = Integer.parseInt(s);
        
        return sign * sToInt;
    }
}