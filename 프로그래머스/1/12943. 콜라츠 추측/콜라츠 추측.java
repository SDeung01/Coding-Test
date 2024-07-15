class Solution {
    public int solution(int num) {
        long numToLong = num;
        
        if(num == 1) return 0;
        
        for(int i = 1; i <= 500; i++){
            if(numToLong%2 == 0){
                numToLong = numToLong/2;
            }else {
                numToLong = numToLong*3 +1;
            }
            
            if(numToLong == 1) return i;
        }
        
        return -1;
    }
}