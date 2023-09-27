class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int sumDenom = denom1 * denom2;
        int sumNumer = (numer1 * denom2) + (numer2 * denom1);
        

            for(int j = 1000; j >= 2; j--){
                if(sumNumer%j == 0 && sumDenom%j == 0){
                    sumNumer /= j;
                    sumDenom /= j;    
                } 
            }
        int[] answer = {sumNumer, sumDenom};
        return answer;
    }
}