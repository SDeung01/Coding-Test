import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> itemMap = new HashMap<>();
        // 종류별로 의상이 몇 벌 있는지 key-value 형태로 Map에 저장한다.
        for(String[] items : clothes){
            itemMap.put(items[1], itemMap.getOrDefault(items[1],0)+1);
        }
        
        // 각 종류별 가짓수(value) + 1(그 종류의 의상을 입지않음)를 모두 곱해준다.
        for(String item : itemMap.keySet()){
            answer *= itemMap.get(item) + 1;
        }
        
        // 모든 종류의 의상을 입지않는 경우 1가지를 뺀다.
        answer -= 1;
        return answer;
    }
}