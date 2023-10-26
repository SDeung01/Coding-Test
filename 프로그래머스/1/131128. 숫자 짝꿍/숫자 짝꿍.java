import java.util.HashMap;
import java.util.Map;
import java.lang.Math;


class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Integer, Integer> mapX = freqMap(X);
        Map<Integer, Integer> mapY = freqMap(Y);

        StringBuilder sb = new StringBuilder("");

        for(int i = 9; i >= 0; i--){
            if(mapX.containsKey(i) && mapY.containsKey(i)){
                    int repeat = (i == 0) && (sb.toString().equals("")) ? 1 : Math.min(mapX.get(i),mapY.get(i));
                    sb.append(makeNum(i,repeat));
            }
        } answer = sb.toString();

        return answer.equals("") ? "-1" : answer;
    }

    private Map<Integer, Integer> freqMap(String strNum){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < strNum.length(); i++){
            int key = strNum.charAt(i) - '0';
            map.put(key, map.getOrDefault(key, 0) + 1);
        } return map;
    }

    private String makeNum(int i, int repeatCnt){
        String num = Integer.toString(i);
        return num.repeat(repeatCnt);
    }
}
// import java.lang.Math;

// class Solution {
//     public String solution(String X, String Y) {
//         int[] arrX = makeArr(X);
//         int[] arrY = makeArr(Y);
        
//         StringBuilder sb = new StringBuilder("");
        
//         for(int i = 9; i >= 0; i--){
//             if(arrX[i] > 0 && arrY[i] > 0){
//                 sb.append(makeNum(i,arrX[i],arrY[i]));
//             }
//         } 
//         String answer = sb.toString();

//         return answer.equals("") ? "-1" : 
//                answer.charAt(0) == '0' ? "0" : answer;
//     }
    
//     private int[] makeArr(String strNum){
//         int[] arr = new int[10];
        
//         for(char ch : strNum.toCharArray()){
//             int num = ch - '0';
//             arr[num] += 1;
//         }
//         return arr;
//     }
    
//     private String makeNum(int i, int X, int Y){
//         String num = Integer.toString(i);
//         return num.repeat(Math.min(X, Y));
//     }
// }
