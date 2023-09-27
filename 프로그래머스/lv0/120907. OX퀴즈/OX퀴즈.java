class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] exp = quiz[i].split(" ");
            boolean ox = false;
            switch(exp[1]){
                case "+":
                    ox = Integer.parseInt(exp[0]) + Integer.parseInt(exp[2]) == Integer.parseInt(exp[4]);
                    result[i] = ox ? "O" : "X";
                    break;
                case "-":
                    ox = Integer.parseInt(exp[0]) - Integer.parseInt(exp[2]) == Integer.parseInt(exp[4]);
                    result[i] = ox ? "O" : "X";
                    break;
            }
        }
        return result;
    }
}