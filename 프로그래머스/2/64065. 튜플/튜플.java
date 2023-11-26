import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 주어진 문자열을 적절히 치환한 후 String 배열 sArr로 나누어 저장한다.
        s = s.replace("},{","/");
        s = s.replaceAll("[{}]","");
        String[] sArr = s.split("/");
        Arrays.sort(sArr, (s1, s2) -> s1.length() - s2.length());
        
        // 2차원 String배열 strTuple에 sArr의 원소("1,2,3" 형태)를 ","를 기준으로 나눈
        // String 배열을 저장한다.
        String[][] strTuple = new String[sArr.length][];
        for(int i = 0; i < strTuple.length; i++){
            strTuple[i] = sArr[i].split(",");
        }
        
        // strTuple의 원소에 해당하는 String배열의 값을 Integer로 바꿔 더한 값을
        // int배열 sumTuple에 저장한다.
        int[] sumTuple = new int[strTuple.length];
        for(int i = 0; i < strTuple.length; i++){
            int sum = 0;
            for(int j = 0; j < strTuple[i].length; j++){
                sum += Integer.parseInt(strTuple[i][j]);
            }
            sumTuple[i] = sum;
        }
        
        // sumTuple의 n번 원소에서 n-1번 원소의 값을 빼주면 튜플의 원소가 된다.
        int[] tuple = new int[sumTuple.length];
        int prevElement = 0;
        for(int i = 0; i < sumTuple.length; i++){
            tuple[i] = sumTuple[i] - prevElement;
            prevElement = sumTuple[i];
        }
        
        return tuple;
    }
}