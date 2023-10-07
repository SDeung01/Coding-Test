import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[][] score) {
        // 주어진 2차원배열 score를 평균점수를 저장한 1차원배열로 변환하여 저장
        double[] avgArr = Arrays.stream(score)
                .mapToDouble(mark -> (double) (mark[0] + mark[1]) / 2)
                .toArray();
        
        // avgArr 배열을 내림차순으로 정렬하여 리스트로 저장
        List<Double> sortAvg = Arrays.stream(avgArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        // avgArr 배열의 요소를 sortAvg 배열에서 찾아 index + 1 하여 등수로 환산하여 저장 
        int[] rankArr = Arrays.stream(avgArr)
                .mapToInt(avg -> sortAvg.indexOf(avg) + 1)
                .toArray();

        return rankArr;
    }
}