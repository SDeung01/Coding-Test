class Solution {
    public int[] solution(int brown, int yellow) {
        int[] carpet = new int[2];
        for(int i = 1; i <= (int) Math.sqrt(yellow); i++){
            if(yellow % i == 0) {
                carpet[0] = yellow / i + 2;
                carpet[1] = i + 2;
                if(carpet[0] * carpet[1] == brown + yellow){
                    break;
                }
            }
        }
                
        return carpet;
    }    
}