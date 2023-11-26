import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replace("},{","/");
        s = s.replaceAll("[{}]","");
        String[] sArr = s.split("/");
        Arrays.sort(sArr, (s1, s2) -> s1.length() - s2.length());
        String[][] strTuple = new String[sArr.length][];
        
        for(int i = 0; i < strTuple.length; i++){
            strTuple[i] = sArr[i].split(",");
        }
        
        int[] sumTuple = new int[strTuple.length];
        for(int i = 0; i < strTuple.length; i++){
            int sum = 0;
            for(int j = 0; j < strTuple[i].length; j++){
                sum += Integer.parseInt(strTuple[i][j]);
            }
            sumTuple[i] = sum;
        }
        
        int[] tuple = new int[sumTuple.length];
        int prevElement = 0;
        for(int i = 0; i < sumTuple.length; i++){
            tuple[i] = sumTuple[i] - prevElement;
            prevElement = sumTuple[i];
        }
        
        return tuple;
    }
}