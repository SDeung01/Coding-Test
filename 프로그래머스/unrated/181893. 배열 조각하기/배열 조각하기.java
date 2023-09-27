import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        List<Integer> arrList = IntStream.of(arr).boxed().collect(Collectors.toList());
        
        for(int idx = 0; idx < query.length; idx++){
            int start = idx%2 == 0 ? arrList.size()-1 : query[idx]-1;
            int end = idx%2 == 0 ? query[idx]+1 : 0;
            for(int i = start; i >= end; i--){
                arrList.remove(i);
            }
        }
        int[] answer = arrList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}