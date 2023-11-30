import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int xLength = maps[0].length;
        int yLength = maps.length;
        int x = 0, y = 0;
        // 탐색지 주변 상하좌우
        int[] aroundX = {0, 0, -1, 1};
        int[] aroundY = {-1, 1, 0, 0};
        int cnt = 0;
        boolean[][] visited = new boolean[yLength][xLength];
        Queue<Point> roadQ = new LinkedList<>();
        roadQ.offer(new Point(x, y));
        visited[y][x] = true;

        while(!roadQ.isEmpty()){
            cnt++;
            int size = roadQ.size();
            for(int i = 0; i < size; i++){
                Point road = roadQ.poll();
                for(int j = 0; j < 4; j++){
                    x = road.x + aroundX[j];
                    y = road.y + aroundY[j];
                    if(x == xLength -1 && y == yLength -1) return ++cnt;
                    if(x >= 0 && x < xLength && y >= 0 && y < yLength){
                        if(maps[y][x] == 0 || visited[y][x]) continue;
                        visited[y][x] = true;
                        roadQ.offer(new Point(x,y));
                    }
                }
            }

        }
        return -1;
    }
    
}