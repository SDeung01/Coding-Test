class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int conversionCnt = 0;
        
        while(!s.equals("1")){
            int sLength = s.length();
            s = s.replace("0","");
            int convLength = s.length();
            conversionCnt += 1;
            zeroCnt += (sLength - convLength);
            s = Integer.toBinaryString(s.length());
        }
        
        return new int[] {conversionCnt, zeroCnt};
    }
}