import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] temp = new int[arr.length];
        Arrays.fill(temp, Integer.MAX_VALUE);
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            int prevNum = i == 0 ? Integer.MAX_VALUE : temp[idx - 1];
            if(prevNum != arr[i]){
                temp[idx] = arr[i];
                idx++;
            }
        }

        return Arrays.copyOfRange(temp, 0, idx);
    }
}