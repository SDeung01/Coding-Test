class Solution {
    public String solution(String[] seoul) {
        int location = 0;
        for(String name : seoul){
            if(name.equals("Kim")) break;
            location++;
        }
        return "김서방은 " + location + "에 있다";
    }
}