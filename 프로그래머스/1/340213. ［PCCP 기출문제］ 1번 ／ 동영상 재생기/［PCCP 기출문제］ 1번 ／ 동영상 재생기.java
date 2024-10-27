class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_sec = minToSec(video_len);
        int pos_sec = minToSec(pos);
        int op_start_sec = minToSec(op_start);
        int op_end_sec = minToSec(op_end);
        
        pos_sec = jumpOp(pos_sec, op_start_sec, op_end_sec);
        
        for(String command : commands){
            pos_sec = movePos(pos_sec, video_len_sec, op_start_sec, op_end_sec, command);
        }
        
        return secToMin(pos_sec);
    }
    
    private int minToSec(String time){
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
    
    private String secToMin(int time){
        String min = String.format("%02d",(time / 60));
        String sec = String.format("%02d",(time % 60));
        return min + ":" + sec;
    }
    
    private int jumpOp(int pos, int op_start, int op_end){
        return pos >= op_start && pos <= op_end ? op_end : pos;
    }
    
    private int movePos(int pos, int video_len, int op_start, int op_end, String command){
        switch(command){
            case "prev" :
                pos = pos - 10 > 0 ? pos - 10 : 0;
                break;
            case "next" :
                pos = pos + 10 < video_len ? pos + 10 : video_len;
                break;
            default :
                pos = pos;
        }
        
        return jumpOp(pos, op_start, op_end);
    }
}