import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;
        // want와 number 두 배열로 나뉘어져있는 원하는 품목과 개수를 하나의 맵으로 만든다.
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int idx = 0; idx < discount.length - 9; idx++){
            if(canSignUp(wantMap, discount, idx)) { cnt++; }
        }
        return cnt;
    }
    // 원하는 조건에 맞춰 가입할 수 있는지 확인
    private boolean canSignUp(Map<String, Integer> wantMap, String[] discount, int idx){
        // 배열 discount에서 요소를 10개씩 꺼내와 Map에 (기간동안의) 할인품목-판매개수 로 저장
        Map<String, Integer> dcMap = new HashMap<>();
        for(int i = idx; i < idx + 10; i++){
            if(wantMap.containsKey(discount[i])){
                dcMap.put(discount[i], dcMap.getOrDefault(discount[i],0) + 1);
            }
        }
        
        // 두 리스트의 크기가 다르다면 희망품목을 기간안에 모두 팔지 않으므로 가입해서는 안된다.
        if(wantMap.size() != dcMap.size()){
                return false;
        } else { // 희망 개수가 판매 개수보다 많으면 역시 가입 불가
            for(String key : dcMap.keySet()){
                if(wantMap.get(key) > dcMap.get(key)){
                    return false;
                }
            }   
        }
        
        return true;
    }
}