import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        Set<Integer> sectionSet = new HashSet<>();

        for(int part : section){
            sectionSet.add(part);
        }

        for(int part : section){
            if(sectionSet.contains(part)){
                for(int i = 0; i < m; i++){
                    if(sectionSet.contains(part + i)) { 
                        sectionSet.remove(part + i);
                    }
                } count++;
            } if(sectionSet.isEmpty()) break;
        }

        return count;
    }
}