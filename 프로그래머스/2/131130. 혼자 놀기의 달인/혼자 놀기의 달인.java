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
                // 1번 그룹에서 선택한 상자는 제외했기 때문에 2번 그룹에서 뽑을 일이 없다.
                // 따라서 -1 일 경우 continue
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

    // 고른 상자 안의 카드에 적힌 숫자에 따라 다음 뽑을 상자를 고름
    // 연 상자에는 표시(-1)를 하고 이미 연 상자를 다 시 고를 때 까지 반복하며 그때까지의 횟수를 반환
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