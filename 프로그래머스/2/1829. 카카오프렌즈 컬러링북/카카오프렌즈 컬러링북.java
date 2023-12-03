import java.util.*;

class Solution {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int count;
    
    public int[] solution(int m, int n, int[][] picture) {      
        boolean[][] visited = new boolean[m][n];
        List<Integer> colorList = new ArrayList<>();
        
        for(int y = 0; y < m; y++){
            for(int x = 0; x < n; x++){
                count = 0;
                int targetColor = picture[y][x];
                if(targetColor > 0){
                    dfs(picture, visited, x, y, targetColor);
                    if(count > 0) colorList.add(count);
                }
            }
        }
        
        Collections.sort(colorList, Collections.reverseOrder());
        
        int numberOfArea = colorList.size();
        int maxSizeOfOneArea = colorList.get(0);

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    private void dfs(int[][] picture, boolean[][] visited, int x, int y, int target){
        int color = picture[y][x];
        if(!visited[y][x] && color == target){
            count++;
            visited[y][x] = true;
            int m = picture.length;
            int n = picture[0].length;
            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                    dfs(picture, visited, nextX, nextY, target);
                }
            }
        }
    }
}