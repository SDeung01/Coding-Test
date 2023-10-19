import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] sameCnt = checkNum(lottos, win_nums);
        int maxSame = sameCnt[0];
        int minSame = sameCnt[1];
        
        int[] ranking = {rank(maxSame), rank(minSame)};
        
        return ranking;
    }
    
    private int[] checkNum(int[] lottos, int[] win_nums){
        int paintCnt = 0;
        int sameCnt = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                paintCnt++;
            } else {
                for(int num : win_nums){
                    if(lottos[i] == num) sameCnt++;
                }
            }
        } return new int[] {paintCnt + sameCnt, sameCnt};
    }
    
    private int rank(int count){
        return count == 6 ? 1 :
               count == 5 ? 2 :
               count == 4 ? 3 :
               count == 3 ? 4 :
               count == 2 ? 5 :
                            6 ;
    }
}