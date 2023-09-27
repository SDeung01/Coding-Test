class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] exp = quiz[i].split(" ");
            int operator = exp[1].equals("+") ? 1 : -1;
            boolean ox = Integer.parseInt(exp[0]) + operator * Integer.parseInt(exp[2]) == Integer.parseInt(exp[4]);
            result[i] = ox ? "O" : "X";
        }
        return result;
    }
}