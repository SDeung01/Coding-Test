import java.util.*;

class Solution {
    public String[] solution(String[] record) {        
        Map<String, String> logMap = new HashMap<>();
        List<String[]> messageList = new ArrayList<>();
        
        for(String log : record){
            String[] logArr = log.split(" ");
            switch(logArr[0]){
                case "Enter":
                    logMap.put(logArr[1],logArr[2]);
                    messageList.add(new String[] {logArr[1], makeMessage(logArr)});
                    break;
                case "Leave":
                    messageList.add(new String[] {logArr[1], makeMessage(logArr)});
                    break;
                case "Change":
                    logMap.put(logArr[1],logArr[2]);
            }
        }
        
        String[] messageArr = new String[messageList.size()];
        for(int i = 0; i < messageList.size(); i++){
            String[] message = messageList.get(i);
            messageArr[i] = message[1].replace(message[0], logMap.get(message[0]));
        }
        
        return messageArr;
    }
    
    private String makeMessage(String[] logArr) {
        if(logArr[0].equals("Enter")){
            return logArr[1] + "님이 들어왔습니다.";
        }else {
            return logArr[1] + "님이 나갔습니다.";
        }
    }
}