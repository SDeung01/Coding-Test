import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int lastIndex = arr.length -1;
        int totalLcm = arr[lastIndex];
        
        for(int i = lastIndex; i >= 0; i--){
            if((arr[i] % totalLcm) > 0){
                totalLcm = lcm(totalLcm, arr[i]);
            }
        }
        
        return totalLcm;
    }
    
    private int gcd(int a, int b){
        if(b == 0){ return a; }
        else {
            return gcd(b, a % b);
        }
    }
    
    private int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}