class Solution {
    public String solution(String s) {
        char[] sCharArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sCharArr.length; i++){
            char ch = sCharArr[i];
            if(i == 0){
                if(ch >= 97 && ch <= 122) ch -= 32;
            }else {
                if(sCharArr[i-1] == ' ' && ch >= 97 && ch <= 122) ch -= 32;
                else if (sCharArr[i-1] != ' ' && ch >= 65 && ch <= 90) ch += 32;
            }

            sb = sb.append(ch);            
        }
        return sb.toString();
    }
}