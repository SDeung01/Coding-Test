import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        class Point {
            private int xPoint;
            private int yPoint;

            public Point(int xPoint, int yPoint) {
                this.xPoint = xPoint;
                this.yPoint = yPoint;
            }

            public int getXPoint() {
                return xPoint;
            }

            public int getYPoint() {
                return yPoint;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return xPoint == point.xPoint && yPoint == point.yPoint;
            }

            @Override
            public int hashCode() {
                return Objects.hash(xPoint, yPoint);
            }
        }

        int count = 0;
        ArrayList<ArrayList<Character>> newBoard = makeNewBoard(m, n, board);
        LinkedHashSet<Point> deletSet = new LinkedHashSet<>();

        while(true){
            for(int y = m - 1; y > 0; y--){ // 삭제할 블록들을 선택하여 deletSet에 담기
                for(int x = 0; x < n - 1; x++){
                    if(canDelet(newBoard, x, y)){
                        deletSet.add(new Point(x,y));
                        deletSet.add(new Point(x + 1,y));
                        deletSet.add(new Point(x,y - 1));
                        deletSet.add(new Point(x + 1,y - 1));
                    }
                }
            }
            if(deletSet.isEmpty()) break;
            for(Point point : deletSet){
                ArrayList<Character> line = newBoard.get(point.getXPoint());
                line.remove(point.getYPoint());
                line.add('0');
                count++;
            }
            deletSet.clear();
        }


        return count;
    }

    private ArrayList<ArrayList<Character>> makeNewBoard(int m, int n, String[] board) {
        ArrayList<ArrayList<Character>> newBoard = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Character> line = new ArrayList<>();
            for(int j = m - 1; j >= 0; j--){
                line.add(board[j].charAt(i));
            } newBoard.add(line);
        }
        return newBoard;
    }

    private boolean canDelet(ArrayList<ArrayList<Character>> newboard, int xPoint, int yPoint){
        char block1 = newboard.get(xPoint).get(yPoint);
        char block2 = newboard.get(xPoint + 1).get(yPoint);
        char block3 = newboard.get(xPoint).get(yPoint - 1);
        char block4 = newboard.get(xPoint + 1).get(yPoint - 1);

        if(block1 == '0' || block2 == '0' || block3 == '0' || block4 == '0') return false;
        else return (block1 == block2) && (block2 == block3) && (block3 == block4);
    }
}