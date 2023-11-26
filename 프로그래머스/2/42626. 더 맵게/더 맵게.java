import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> hotQ = new PriorityQueue<>();
        for(int hot : scoville){
            hotQ.offer(hot);
        }

        while(hotQ.peek() < K) {
            int lessHot = hotQ.poll();
            if(hotQ.size() < 1 && lessHot < K) return -1;
            int lessHot2nd = hotQ.poll();
            int mixedHot = lessHot + (lessHot2nd * 2);
            hotQ.offer(mixedHot);
            answer++;
        }

        return answer;
    }
}