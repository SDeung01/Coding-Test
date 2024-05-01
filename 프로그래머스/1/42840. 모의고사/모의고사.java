import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] firstAnswers = {1, 2, 3, 4, 5};
        int[] secondAnswers = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdAnswers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        Map<Integer, Integer> scoreMap = new HashMap<>();
        
        for(int quizNum = 0; quizNum < answers.length; quizNum++){
            int firstNum = quizNum % firstAnswers.length;
            int secondNum = quizNum % secondAnswers.length;
            int thirdNum = quizNum % thirdAnswers.length;
            
            if(answers[quizNum] == firstAnswers[firstNum]){
                scoreMap.put(1, scoreMap.getOrDefault(1, 0) + 1);
            }
            if(answers[quizNum] == secondAnswers[secondNum]){
                scoreMap.put(2, scoreMap.getOrDefault(2, 0) + 1);
            }
            if(answers[quizNum] == thirdAnswers[thirdNum]){
                scoreMap.put(3, scoreMap.getOrDefault(3, 0) + 1);
            }
        }
        
        Integer maxScore = Collections.max(scoreMap.values());
        
        List<Integer> winnerList = new ArrayList<>();
        
        for(Integer key : scoreMap.keySet()){
            if(scoreMap.get(key).equals(maxScore)){
                winnerList.add(key);
            }
        }
        
        Collections.sort(winnerList);
        
        int[] winners = winnerList.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();

        return winners;
    }
}