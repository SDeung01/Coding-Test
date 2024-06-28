import java.util.Arrays;

class Solution {
    public String solution(String s) {      
        String[] strArr = s.split(" ");
//         int[] numArr = new int[strArr.length];
        
//         for(int i = 0; i < strArr.length; i++){
//             numArr[i] = Integer.parseInt(strArr[i]);
//         }
        
//         Arrays.sort(numArr);
        
//         return numArr[0] + " " + numArr[numArr.length -1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String strNum : strArr){
            int num = Integer.parseInt(strNum);
            if(num < min){ min = num; }
            if(num > max){ max = num; }
        }
        
        return min + " " + max;
    }
}