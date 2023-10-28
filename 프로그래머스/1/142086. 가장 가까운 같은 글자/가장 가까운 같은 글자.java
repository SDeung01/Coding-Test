class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(s.indexOf(ch) != i) {
                answer[i] = i - s.lastIndexOf(ch, i - 1);
            } else answer[i] = -1;
        }
        return answer;
    }
}