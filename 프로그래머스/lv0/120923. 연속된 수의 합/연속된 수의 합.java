import java.util.Arrays;

class Solution {
    public int[] solution(int num, int total) {
        int[] result = new int[num];
        for(int i = 0; i < num; i++){
            int shift = i%2 == 0 ? -1 : 1;
            int change = i%2 == 0 ? i/2 : i/2 + 1;
            result[i] = total/num + shift*change;
        }
        Arrays.sort(result);
        return result;
    }
}