import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] array) {
        // 중복값 확인을 위해 배열 -> 리스트
        List<Integer> arrList = IntStream.of(array).boxed().collect(Collectors.toList());
        List<Integer> freqList = new ArrayList<>();
        
        // 확인한 중복값을 새로 만든 중복값리스트에 저장
        for(int i = 0; i < arrList.size(); i++){
            freqList.add(Collections.frequency(arrList,arrList.get(i)));
        }
        
        int maxFreq = freqList.stream().mapToInt(i -> i).max().orElse(0);
        int maxFreqFreq = Collections.frequency(freqList, maxFreq);
        int maxIndex = freqList.indexOf(maxFreq);
        int mode = arrList.get(maxIndex);

        // 최빈값이 하나 이상인지 확인하여(중복값의 중복값과 중복값을 비교) -1 or 최빈값 출력
        return maxFreq == maxFreqFreq ? mode : -1;
    }
}