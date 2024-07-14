class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        if(a == b){
            return (long) a;
        }else {
            long max = Math.max(a, b);
            long min = Math.min(a, b);
            
            for(long num = min; num <= max; num++){
                sum += num;
            }
        }
        return sum;
    }
}