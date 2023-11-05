import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int total = 0;
        
        // 귤 사이즈, 개수 의 형태로 map에 저장
        Map<Integer, Integer> gyulMap = new HashMap<>();
        
        for(int size : tangerine){
            gyulMap.put(size, gyulMap.getOrDefault(size,0)+1);
        }
        
        // 개수가 많은 순으로 정렬하기 위해 map의 keySet을 리스트로 받아 내림차순으로 정렬
        List<Integer> sizeList = new ArrayList<>(gyulMap.keySet());
        sizeList.sort((s1,s2) -> gyulMap.get(s2).compareTo(gyulMap.get(s1)));
    
        // 정렬된 리스트의 요소를 key로 사용
        // 한 사이즈의 귤을 모두 상자에 담고 상자가 넘치면 break
        for(int size : sizeList){
            total += gyulMap.get(size);
            answer++;
            if(total >= k) break;
        }
        
        
        return answer;
    }
}