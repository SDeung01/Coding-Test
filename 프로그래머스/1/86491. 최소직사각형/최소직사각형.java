class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        
        for(int[] nameCard : sizes){
            int width = Math.max(nameCard[0],nameCard[1]);
            int height = Math.min(nameCard[0],nameCard[1]);
            
            if(width > maxWidth) maxWidth = width;
            if(height > maxHeight) maxHeight = height;
        }
        
        return maxWidth * maxHeight;
    }
}