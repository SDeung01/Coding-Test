import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String message = "";

        Map<String, String> dataBase = Arrays.stream(db)
                .collect(Collectors.toMap(profile -> profile[0], profile -> profile[1]));

        if(dataBase.containsKey(id_pw[0])){
            message = (dataBase.get(id_pw[0]).equals(id_pw[1])) ? "login" : "wrong pw";
        } else {
            message = "fail";
        }


        return message;
    }
}