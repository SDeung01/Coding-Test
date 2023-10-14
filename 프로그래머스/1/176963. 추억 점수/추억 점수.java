import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] memory = new int[photo.length];
        Map<String, Integer> nameMap = new HashMap<>();

        // 인물의 이름을 key로, 대응하는 그리움 점수를 value로 저장
        for(int i = 0; i < name.length; i++){
            nameMap.put(name[i], yearning[i]);
        }

        // 사진에 나오는 인물이 그리운 인물(key)면 그리움 점수(value)를 추억점수에 더하고,
        // 명단에 없는 인물이면 0점(default값)을 더한다.
        for(int j = 0; j < photo.length; j++){
            int memoryPoint = 0;
            for (String key : photo[j]) {
                memoryPoint += nameMap.getOrDefault(key, 0);
            } memory[j] = memoryPoint;
        }

        return memory;
    }
}
