class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            StringBuilder temp = new StringBuilder();
            for (int i = end; i >= start; i--) {
                temp.append(my_string.charAt(i));
            }
            String tempStr = temp.toString();
            my_string = sb.replace(start, end+1, tempStr).toString();
        }
        return my_string;
    }
}