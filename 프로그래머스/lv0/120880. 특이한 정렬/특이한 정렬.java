import java.util.Arrays;

class Solution {
    public static int[] solution(int[] numlist, int n) {
        int[] numList = Arrays.stream(numlist).sorted().toArray();
        int[] approxArr = new int[numList.length];
        for (int i = 0; i < numList.length; i++) {
            int near = Integer.MAX_VALUE;
            int approx = 0;
            int idx = 0;
            for (int j = 0; j < numList.length; j++) {
                if (Math.abs(n - numList[j]) <= near) {
                    near = Math.abs(n - numList[j]);
                    approx = numList[j];
                    idx = j;
                }
            }
            numList[idx] = Integer.MAX_VALUE;
            approxArr[i] = approx;
        }

        return approxArr;
    }
}