import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] minTouch = new int['Z' - 'A' + 1];
        Arrays.fill(minTouch, 200);
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                minTouch[key.charAt(i) - 'A'] = Math.min(minTouch[key.charAt(i) - 'A'], i + 1);
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean canMake = true;
            for (int j = 0; j < target.length(); j++) {
                if (minTouch[target.charAt(j) - 'A'] == 200) {
                    canMake = false;
                    break;
                }
                sum += minTouch[target.charAt(j) - 'A'];
            }
            answer[i] = canMake ? sum : -1;
        }
        return answer;
    }
}