class Solution {
    public long[] solution(int x, int n) {
        long[] arr = new long[n];
        for(int idx = 0; idx < n; idx++){
            arr[idx] = (long) x * (idx +1);
        }
        return arr;
    }
}