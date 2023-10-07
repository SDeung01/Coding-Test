import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[][] score) {
        double[] avgArr = Arrays.stream(score)
                .mapToDouble(mark -> (double) (mark[0] + mark[1]) / 2)
                .toArray();
        
        List<Double> sortAvg = Arrays.stream(avgArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        int[] rankArr = Arrays.stream(avgArr)
                .mapToInt(avg -> sortAvg.indexOf(avg) + 1)
                .toArray();

        return rankArr;
    }
}