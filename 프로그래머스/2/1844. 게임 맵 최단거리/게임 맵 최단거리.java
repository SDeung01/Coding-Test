import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    class Point {
        private int x;
        private int y;
        private int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        int xLength = maps[0].length;
        int yLength = maps.length;
        // 탐색지 주변 상하좌우
        int[] aroundX = {0, 0, -1, 1};
        int[] aroundY = {-1, 1, 0, 0};
        boolean[][] visited = new boolean[yLength][xLength];
        Queue<Point> roadQ = new LinkedList<>();
        roadQ.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!roadQ.isEmpty()){
            Point road = roadQ.poll();
            int distance = road.distance;
            for(int j = 0; j < 4; j++){
                int x = road.x + aroundX[j];
                int y = road.y + aroundY[j];
                if(x == xLength -1 && y == yLength -1) return distance+1;
                if(x >= 0 && x < xLength && y >= 0 && y < yLength){
                    if(maps[y][x] == 0 || visited[y][x]) continue;
                    visited[y][x] = true;
                    roadQ.offer(new Point(x, y, distance +1));
                }
            }
        }
        
        return -1;
    }
    
}