class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            String map1 = Integer.toBinaryString(arr1[i]);
            String map2 = Integer.toBinaryString(arr2[i]);
            long longMap1 = Long.parseLong(map1);
            long longMap2 = Long.parseLong(map2);
            String map = String.format("%0"+n+"d", longMap1 + longMap2);
            map = map.replace("0"," ");
            map = map.replace("1","#");
            map = map.replace("2","#");
            answer[i] = map;
        }
        return answer;
    }
}