import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        int star = Integer.MAX_VALUE, sharp = Integer.MIN_VALUE;
        List<Integer> keypad = Arrays.asList(1,2,3,4,5,6,7,8,9,star,0,sharp);

        int[] prev_L = {1,4}, prev_R = {3,4};
        StringBuilder sb = new StringBuilder();

        for(int number : numbers){
            int [] now = location(keypad,number);

            if(number % 3 == 1){
                sb.append("L");
                prev_L = now;
            } else if (number % 3 == 0 && number != 0){
                sb.append("R");
                prev_R = now;
            } else {
                int distance_L = distance(now, prev_L);
                int distance_R = distance(now, prev_R);
                if(distance_L < distance_R) {
                    sb.append("L");
                    prev_L = now;
                } else if (distance_L > distance_R) {
                    sb.append("R");
                    prev_R = now;
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        prev_L = now;
                    } else {
                        sb.append("R");
                        prev_R = now;
                    }
                }
            }
        }
        return sb.toString();
    }

    private int[] location(List<Integer> keypad, int number){
        int xPoint = (keypad.indexOf(number) % 3) + 1;
        int yPoint = (keypad.indexOf(number) / 3) + 1;
        int[] loc = {xPoint, yPoint};
        return loc;
    }

    private int distance(int[] now, int[] prev){
        return Math.abs(prev[0] - now[0]) + Math.abs(prev[1] - now[1]);
    }
    
}