import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<Integer>();
        int i = 0;
        while(i < arr.length){
            int lastIndex = stk.size() - 1;
            if(stk.isEmpty()){
                stk.add(arr[i]);
                i++; 
            } else {
                if(stk.get(lastIndex) < arr[i]){
                    stk.add(arr[i]);
                    i++;
                } else {
                    stk.remove(lastIndex);
                }
            }
        }
        int[] stkArr = stk.stream().mapToInt(Integer::intValue).toArray();
        return stkArr;
    }
}