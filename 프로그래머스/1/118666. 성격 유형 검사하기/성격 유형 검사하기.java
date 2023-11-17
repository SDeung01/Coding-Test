import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> mbtiMap = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++){
            int choice = choices[i];
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            switch(choice){
                case 1:
                    mbtiMap.put(disagree, mbtiMap.getOrDefault(disagree, 0) + 3);
                    break;
                case 2:
                    mbtiMap.put(disagree, mbtiMap.getOrDefault(disagree, 0) + 2);
                    break;
                case 3:
                    mbtiMap.put(disagree, mbtiMap.getOrDefault(disagree, 0) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    mbtiMap.put(agree, mbtiMap.getOrDefault(agree, 0) + 1);
                    break;
                case 6:
                    mbtiMap.put(agree, mbtiMap.getOrDefault(agree, 0) + 2);
                    break;
                case 7:
                    mbtiMap.put(agree, mbtiMap.getOrDefault(agree, 0) + 3);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb = sb.append(selectType('R','T',mbtiMap));
        sb = sb.append(selectType('C','F',mbtiMap));
        sb = sb.append(selectType('J','M',mbtiMap));
        sb = sb.append(selectType('A','N',mbtiMap));
    
        return sb.toString();
    }
    
    private char selectType(char type1, char type2, Map<Character, Integer> mbtiMap){
        if(!mbtiMap.containsKey(type1)) mbtiMap.put(type1, 0);
        if(!mbtiMap.containsKey(type2)) mbtiMap.put(type2, 0);
        if(mbtiMap.get(type1) > mbtiMap.get(type2)) return type1;
        else if(mbtiMap.get(type1) < mbtiMap.get(type2)) return type2;
        else return (char)(Math.min(type1, type2));
    }
}