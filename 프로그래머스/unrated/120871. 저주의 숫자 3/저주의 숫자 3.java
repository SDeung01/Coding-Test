class Solution {
    public int solution(int n) {
        int x3_Num = 0;
        String x3_Str = "";
        for(int decimal = 1; decimal <= n; decimal++){
            do {
                x3_Num++;
                x3_Str = Integer.toString(x3_Num);
            }  while(x3_Num % 3 == 0 || x3_Str.contains("3"));
        }
        return x3_Num;
    }
}