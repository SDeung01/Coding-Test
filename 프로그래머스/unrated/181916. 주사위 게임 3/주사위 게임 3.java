import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> dice = new ArrayList<>(Arrays.asList(a,b,c,d));
        int answer = 0;
        int p = 0, q = 0, r = 0;
        int uno = 0, duo = 0, trio = 0, quattro = 0;
        for(int i = 1; i <= 6; i++){
            int count = Collections.frequency(dice, i);
            if(count == 1){ uno++; if(q == 0) q = i; else r = i;}
            else if(count == 2){ duo++; if(p == 0)p = i; else q = i;}
            else if(count == 3){ trio++; p = i; }
            else if(count == 4){ quattro++; p = i;}
        }
        
        if(quattro == 1){ answer = 1111 * p; }
        else if(trio == 1){ answer = (int) Math.pow(10 * p + q,2); }
        else if(duo == 2){ answer = (p + q) * (int) Math.abs(p - q); }
        else if (duo == 1 && uno == 2){ answer = q * r; }
        else { answer = Collections.min(dice); }
        
        return answer;
    }
}