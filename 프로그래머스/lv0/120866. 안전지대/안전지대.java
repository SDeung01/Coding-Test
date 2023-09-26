import java.util.*;

class Solution {
    public static int solution(int[][] board) {
        //n*n 크기의 board를 순차적으로 이동하여 지뢰 탐색
        //탐색한 지뢰(1)의 주변으로 위험지역(2) 설정(2차원배열 범위 내 일 경우만 설정)
        //board를 다시 순차적으로 이동하며 안전지대의 수 체크 후 리턴
        int[] aroundX = {-1,0,1,1,1,0,-1,-1};
        int[] aroundY = {-1,-1,-1,0,1,1,1,0};
        
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if(board[x][y] == 1){
                    //탐색한 지뢰(board[x][y]) 주변 8칸(최대)에 위험지역 설정
                    for (int i = 0; i < 8; i++) {
                        int expX = x + aroundX[i];
                        int expY = y + aroundY[i];
                        //2차원배열 범위 내 인지 확인하여 탐색한 지뢰의 주변으로 위험지역을 설정한다.
                        //이때 위험지역 내에 지뢰가 있을 시 지뢰(1)로 설정.
                        if(expX >= 0 && expX < board[x].length && expY >= 0 && expY < board.length){
                            board[expX][expY] = board[expX][expY] == 1 ? 1 : 2;
                        }
                    }
                }
            }
        }
        // 탐색한 결과를 토대로 안전지대의 수 체크
        int count = 0;

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if(board[x][y] == 0) count++;
            }
        }
        return count;
    }
}