class Solution {
    public int solution(String A, String B) {
        int lastIdx = A.length()-1;
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.equals(B)) break;
            else { A = A.charAt(lastIdx) + A.substring(0,lastIdx); count++; }
        }
        return A.equals(B) ? count : -1;
    }
}