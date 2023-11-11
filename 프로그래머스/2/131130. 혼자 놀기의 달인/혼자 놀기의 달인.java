class Solution {
    public int solution(int[] cards) {
        int highScore = Integer.MIN_VALUE;
        for(int i = 0; i < cards.length; i++){
            int[] cardArr = cards.clone();
            //group1
            int score1 = group(cardArr, i);
            if(score1 == cardArr.length) { return 0; }
            //group2
            for(int j = 0; j < cardArr.length; j++){
                int[] leftCards = cardArr.clone();
                if(leftCards[j] == -1) { continue; }
                int score2 = group(leftCards, j);
                int newScore = score1 * score2;
                if(newScore > highScore) {
                    highScore = newScore;
                }
            }
        }

        return highScore;
    }

    private int group (int[] cardArr, int startIdx){
        int selectIdx = startIdx;
        int cnt = 0;
        while(cardArr[selectIdx] > -1){
            int card = cardArr[selectIdx];
            cardArr[selectIdx] = -1;
            selectIdx = card - 1;
            cnt++;
        }
        return cnt;
    }
}