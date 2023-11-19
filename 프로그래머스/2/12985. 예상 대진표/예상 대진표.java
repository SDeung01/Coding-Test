class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;
        a -= 1;
        b -= 1;
        while(true){
            if(a / 2 == b / 2) break;
            a = a / 2;
            b = b / 2;
            round++;
        }


        return round;
    }
}