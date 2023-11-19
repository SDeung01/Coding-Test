import java.util.*;

class Solution {
    public String[] solution(String[] record) {        
        Map<String, String> userMap = new HashMap<>();
        List<String[]> commandList = new ArrayList<>();
        
        for(String log : record){
            String[] logArr = log.split(" ");
            switch(logArr[0]){
                case "Enter":
                    userMap.put(logArr[1],logArr[2]);
                    commandList.add(new String[] {logArr[1], logArr[0]});
                    break;
                case "Leave":
                    commandList.add(new String[] {logArr[1], logArr[0]});
                    break;
                case "Change":
                    userMap.put(logArr[1],logArr[2]);
            }
        }
        
        String[] messages = new String[commandList.size()];
        for(int i = 0; i < commandList.size(); i++){
            String[] commandArr = commandList.get(i);
            String userId = commandArr[0];
            String command = commandArr[1];
            String nickName = userMap.get(userId);
            messages[i] = makeMessage(command, nickName);
        }
        
        return messages;
    }
    
    private String makeMessage(String command, String nickName) {
        if(command.equals("Enter")){
            return nickName + "님이 들어왔습니다.";
        }else {
            return nickName + "님이 나갔습니다.";
        }
    }
}