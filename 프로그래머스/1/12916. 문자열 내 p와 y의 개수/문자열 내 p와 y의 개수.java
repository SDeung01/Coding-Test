class Solution {
    boolean solution(String s) {
        int countP = 0;
        int countY = 0;
        
        String lowerStr = s.toLowerCase();
    
        for(int i = 0; i < lowerStr.length(); i++) {
            if(lowerStr.charAt(i) =='p'){
                countP++;
            }
        }
        for(int i = 0; i < lowerStr.length(); i++){
            if(lowerStr.charAt(i) =='y'){
                countY++;
            }
        }
        
        return countP == countY;
    }
}