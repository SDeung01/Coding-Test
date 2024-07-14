class Solution {
    public boolean solution(int x) {
        int digitSum = 0;
        int num = x;
        while(num > 0){
            digitSum += num % 10;
            num = num / 10;
        }
        
        return x % digitSum == 0;
    }
}