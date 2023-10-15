import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] keyCount = new int[targets.length];
        Map<Character, Integer> keyboard = makeKeyMap(keymap);

        // 입력하려는 문자열 target의 문자를 입력하기 위한 횟수를 count에 합산.
        // 주어진 자판으로 입력할 수 없는 문자가 있다면 -1을 배열에 저장.
        for(int i = 0; i < targets.length; i++){
            int count = 0;
            String target = targets[i];
            for(int j = 0; j < target.length(); j++){
                char targetCh = target.charAt(j);
                if(keyboard.containsKey(targetCh)) { count += keyboard.get(targetCh); }
                else { count = -1; break; }
            }
            keyCount[i] = count;
        }

        return keyCount;
    }

    // keymap의 여러 자판 중 특정 알파벳을 가장 빠르게 입력할 수 있는 값을 저장한 HashMap을 만든다.
    // Map(알파벳, 가장 빠르게 입력할 수 있는 횟수)
    private HashMap<Character, Integer> makeKeyMap(String[] keymap) {
        HashMap<Character, Integer> keyboard = new HashMap<>();

        for (String keyStr : keymap){
            for (int i = 0; i < keyStr.length(); i++){
                char key = keyStr.charAt(i);
                if(!keyboard.containsKey(key)){
                    keyboard.put(key, i + 1);
                } else {
                    if(keyboard.get(key) > i + 1) {
                        keyboard.put(key, i + 1);
                    }
                }
            }
        } return keyboard;
    }

}