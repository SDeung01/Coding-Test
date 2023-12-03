import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> numberQ = new LinkedList<>();
        Set<Integer> numberSet = new HashSet<>();
        
        numberQ.offer(x);
        if(x == y) return 0;
        
        while(!numberQ.isEmpty()){
            count++;
            int size = numberQ.size();
            for(int i = 0; i < size; i++){
                int num = numberQ.poll();
                int numX2 = num * 2;
                int numX3 = num * 3;
                int numPlusN = num + n;
                if(numX2 == y || numX3 == y || numPlusN == y) return count;
                if(numX2 < y && numberSet.add(numX2)) numberQ.offer(numX2);
                if(numX3 < y && numberSet.add(numX3)) numberQ.offer(numX3);
                if(numPlusN < y && numberSet.add(numPlusN)) numberQ.offer(numPlusN);
            }
        }
        return -1;
    }
}