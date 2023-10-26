import java.util.HashMap;
import java.util.Map;
import java.lang.Math;


class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Integer, Integer> mapX = freqMap(X);
        Map<Integer, Integer> mapY = freqMap(Y);

        StringBuilder sb = new StringBuilder("");

        // 큰 수 부터 작은 수로 반복해야 가장 큰 값을 구할 수 있다.
        // "00~0"의 경우 "0"으로 출력되어야 하므로 반복횟수를 1회
        // 그 외는 같은 숫자의 중복도 중 낮은 값으로 반복한다.
        // (예를 들어 2가 각각 2개 3개 있다면 2번만 사용할 수 있다.)
        for(int i = 9; i >= 0; i--){
            if(mapX.containsKey(i) && mapY.containsKey(i)){
                int repeat = (i == 0) && (sb.toString().equals("")) ? 1 : Math.min(mapX.get(i),mapY.get(i));
                sb.append(makeNum(i,repeat));
            }
        } answer = sb.toString();
        // 만약 마지막까지 동일한 숫자가 없다면 "-1" 을 반환한다.
        return answer.equals("") ? "-1" : answer;
    }

    // 0~9 사이에 존재하는 정수 k의 중복도를 value로 가지는 Map을 반환한다.
    private Map<Integer, Integer> freqMap(String strNum){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < strNum.length(); i++){
            int key = strNum.charAt(i) - '0';
            map.put(key, map.getOrDefault(key, 0) + 1);
        } return map;
    }

    // 숫자를 중복도만큼 반복한 문자열을 반환한다.
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
