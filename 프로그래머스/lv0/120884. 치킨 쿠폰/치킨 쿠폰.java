class Solution {
    public int solution(int chicken) {

        int maxService = 0;
        
        while(chicken / 10 != 0){
            int service = chicken / 10;
            chicken = service + chicken % 10;
            
            maxService += service;
        }

        return maxService;
    }
}