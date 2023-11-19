class Solution {
    public int[] solution(int n) {
        int[][] snailArr = new int[n][];
        for(int i = 0; i < n; i++){
            snailArr[i] = new int[i+1];
        }

        int count = snailLength(n);
        int num = 1;
        int turn = 0;
        int pointX = 0, pointY = 0;
        int top = 0, bottom = n - 1;
        int vertexX = 0, vertexY = n - 1;
        int[] answer = new int[count];

        while(count > 0){
            snailArr[pointY][pointX] = num++;
            if(pointX == vertexX && pointY == vertexY) { turn++; }
            switch(turn % 3){
                case 0:
                    if(pointX == vertexX && pointY == vertexY) {
                        vertexY = --bottom;
                        vertexX = turn / 3;
                    }
                    pointY++;
                    break;
                case 1:
                    if(pointX == vertexX && pointY == vertexY) {
                        vertexX = snailArr[vertexY].length - (1 + turn / 3);
                    }
                    pointX++;
                    break;
                case 2:
                    if(pointX == vertexX && pointY == vertexY) {
                        top += Math.min((turn + 1) / 3, 2);
                        vertexY = top;
                        vertexX = snailArr[vertexY].length - (turn + 1) / 3;
                    }
                    pointX--;
                    pointY--;
                    break;
            }
            count--;
        }

        int idx = 0;
        for(int[] y : snailArr){
            for(int x : y){
                answer[idx++] = x;
            }
        }

        return answer;
    }

    private int snailLength(int n){
        if(n == 1){
            return 1;
        } else return n + snailLength(n-1);
    }
}