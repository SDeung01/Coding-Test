class Solution {
    public double solution(int[] numbers) {
        double answer = 0;

        double sum = 0;
        for(int i: numbers){
            sum+=i;
        }
        
        double average = sum / numbers.length ;
        answer = Math.round(average*10)/10.0;
        
        
        return answer;
    }
}