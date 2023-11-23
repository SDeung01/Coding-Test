class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int conversionCnt = 0;
        
        while(!s.equals("1")){
            String temp = s.replace("0","");
            conversionCnt += 1;
            zeroCnt += (s.length() - temp.length());
            s = Integer.toBinaryString(temp.length());
        }
        
        return new int[] {conversionCnt, zeroCnt};
    }
}