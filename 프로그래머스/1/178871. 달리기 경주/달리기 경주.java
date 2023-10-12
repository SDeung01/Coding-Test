import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>(); // Map(선수이름, index)
        for(int i = 0; i < players.length; i++){
            playerMap.put(players[i],i);
        }

        // 해설진이 외친 횟수만큼 추월 반복
        for(String calledPlayer : callings){
            int nowRank = callIndex(playerMap, calledPlayer);
            overtaking(playerMap, players, nowRank);
        }

        return players;
    }

    // 해설진에게 불린 선수의 위치(index)를 구한다.(index +1 할 시 등수)
    private int callIndex(Map<String,Integer> playerMap, String calledPlayer) {

        return playerMap.get(calledPlayer);
    }

    // 해설진에게 불린 선수의 위치와 앞선 선수의 위치를 뒤바꾼다.
    // 제한조건 상 1등은 불리지 않지만 만약 불린 선수의 index가 0이라면 선두 메세지 출력 후 등수 유지
    private void overtaking(Map<String,Integer> playerMap, String[] players, int callIndex) {
        String calledPlayer = players[callIndex];
        String frontPlayer = "";
        if(callIndex > 0 ) { frontPlayer = players[callIndex-1]; }
        else { frontPlayer = calledPlayer; }

        if(callIndex > 0) {
            playerMap.put(calledPlayer , playerMap.get(calledPlayer) - 1);
            playerMap.put(frontPlayer , playerMap.get(frontPlayer) + 1);
            players[playerMap.get(calledPlayer)] = calledPlayer;
            players[playerMap.get(frontPlayer)] = frontPlayer;
        } else {
            System.out.printf("\"%s\"선수가 여전히 1등으로 달리고 있습니다.\n",calledPlayer);
        }
    }
}