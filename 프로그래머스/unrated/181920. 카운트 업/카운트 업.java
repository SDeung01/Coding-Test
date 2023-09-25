import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = start_num; i <= end_num; i++){
            list.add(i);
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}