class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // 초기 좌표
        int x_point = 0;
        int y_point = 0;
        
        // 키보드 입력에 따른 좌표 이동
        for (String move : keyinput) {
            switch(move) {
                case "left" : x_point--; break;
                case "right" : x_point++; break;
                case "up" : y_point++; break;
                case "down" : y_point--; break;
            }
            
            // 맵 밖으로 이동할 경우 맵의 끝에 위치시킴
            if (Math.abs(x_point) > board[0] / 2) {
                x_point = x_point >= 0 ? board[0] / 2 : -1 * board[0] / 2 ;
            } else if(Math.abs(y_point) > board[1] / 2){
                y_point = y_point >= 0 ? board[1] / 2 : -1 * board[1] / 2 ;
            }
        }
        
        
        
        int[] coordinate = {x_point, y_point};
        
        return coordinate;
    }
}