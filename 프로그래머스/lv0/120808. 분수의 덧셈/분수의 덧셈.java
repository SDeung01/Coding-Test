class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int bigDenom = Math.max(denom1,denom2);
        int smallDenom = Math.min(denom1,denom2);
        
        int bigNumer = bigDenom == denom1 ? numer1 : numer2;
        int smallNumer = smallDenom == denom1 ? numer1 : numer2;
        
        int sumDenom = bigDenom * smallDenom;
        int sumNumer = (bigNumer * smallDenom) + (smallNumer * bigDenom);
        

        for(int i = 0; i < 10; i++){
            for(int j = 2; j <= 1000; j++){
                if(sumNumer%j == 0 && sumDenom%j == 0){
                    sumNumer /= j;
                    sumDenom /= j;    
                } 
            }
        }
        int[] answer = {sumNumer, sumDenom};
        return answer;
    }
}