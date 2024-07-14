class Solution {
    public int[] solution(long n) {
        int nLength = (int)(Math.log10(n) + 1);     
        int[] reverseArr = new int[nLength];
        
        for(int idx = 0; idx < nLength; idx++){
            reverseArr[idx] = (int)(n % 10);
            n = n / 10;
        }
        return reverseArr;
    }
}