class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if(sqrt == Math.floor(sqrt)){
            return (long) Math.pow((long)sqrt +1, 2);
        }else {
            return -1;
        }
    }
}