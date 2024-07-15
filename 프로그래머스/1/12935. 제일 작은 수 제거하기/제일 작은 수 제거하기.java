class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }else {
            int[] removedMinArr = new int[arr.length -1];
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            
            for(int i = 0; i < arr.length; i++){
                int num = arr[i];
                if(num < min){
                    min = num;
                    minIdx = i;
                }
            }
            
            int idx = 0;
            
            for(int i = 0; i < arr.length; i++){
                if(i == minIdx) continue;
                removedMinArr[idx++] = arr[i];
            }
            
            return removedMinArr;
        }
    }
}