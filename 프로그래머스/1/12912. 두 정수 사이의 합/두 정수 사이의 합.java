class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        if(a == b){
            return (long) a;
        }else {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            
            for(int num = min; num <= max; num++){
                sum += num;
            }
        }
        return sum;
    }
}