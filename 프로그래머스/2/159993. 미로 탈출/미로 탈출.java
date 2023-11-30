import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    class Point{
        private final int x;
        private final int y;
        private final int sec;

        public Point(int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
    }
    
    public int solution(String[] maps) {
        
        int xLength = maps[0].length();
        int yLength = maps.length;
        boolean[][] visited = new boolean[yLength][xLength];
        Queue<Point> roadQ = new LinkedList<>();
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // x,y 상하좌우
        
        int[] start = findStart(maps);
        roadQ.offer(new Point(start[0], start[1], 0));
        visited[start[1]][start[0]] = true;
        
        char targetL = 'L';
        Point leverPoint = goToPoint(roadQ, maps, visited, direction, xLength, yLength, targetL);
        if(leverPoint == null) return -1;
        
        roadQ.clear();
        visited = new boolean[yLength][xLength];
        
        roadQ.offer(leverPoint);
        visited[leverPoint.y][leverPoint.x] = true;
        
        char targetE = 'E';
        Point exitPoint = goToPoint(roadQ, maps, visited, direction, xLength, yLength, targetE);
        if(exitPoint == null) return -1;
        
        return exitPoint.sec;
    }
    
    private int[] findStart(String[] maps){
        for(int y = 0; y < maps.length; y++){
            for(int x = 0; x < maps[0].length(); x++){
                if(maps[y].charAt(x) == 'S') return new int[] {x, y};
            }
        } return new int[] {0, 0};
    }
    
    private Point goToPoint(Queue<Point> roadQ, String[] maps, boolean[][] visited, int[][] direction, int xLength, int yLength, char target){
        while(!roadQ.isEmpty()){
            Point road = roadQ.poll();
            int sec = road.sec;
            for(int[] dir : direction){
                int x = road.x + dir[0];
                int y = road.y + dir[1];
                if(x >= 0 && x < xLength && y >= 0 && y < yLength){
                    if(visited[y][x] || maps[y].charAt(x) == 'X') continue;
                    if(maps[y].charAt(x) == target) return new Point(x,y,sec+1);
                    visited[y][x] = true;
                    roadQ.offer(new Point(x,y,sec+1));
                }
            }
        } return null;
    }
    
}