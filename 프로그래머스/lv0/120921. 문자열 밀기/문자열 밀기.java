class Solution {
    public int solution(String A, String B) {
        int lastIdx = A.length()-1;
        int count = 0;
        String temp = A;
        
        for(int i = 0; i < A.length(); i++){
            if(temp.equals(B)) break;
            StringBuilder sb = new StringBuilder();
            sb.append(temp.charAt(lastIdx)).append(temp.substring(0,lastIdx));
            temp = sb.toString();
            count++;
        }
        return temp.equals(B) ? count : -1;
    }
}