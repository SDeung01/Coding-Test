class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for(String babble : babbling){
            if(babble.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")) count++;
        }
        return count;
    }
}