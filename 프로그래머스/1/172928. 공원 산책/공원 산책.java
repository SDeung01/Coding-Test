// 스타트 포인트 탐색
// 이동경로에서 이동 방향과 거리를 따로 나눠 List로 저장
// 다음 명령에 따른 이동 위치 확인
// 이동할 위치가 공원을 벗어나지 않는가?
// 이동 중에 장애물을 만나지 않는가?
// 다음 이동 위치로 좌표 변경

import java.util.ArrayList;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] nowPoint = startPoint(park);

        for(String[] order : nextOrder(routes)){
            int y_point = nowPoint[0];
            int x_point = nowPoint[1];
            int[] targetPoint = nextPoint(y_point, x_point, order);
            if(inPark(park, targetPoint) && noBlock(y_point, x_point, park, order)){
                nowPoint[0] = targetPoint[0];
                nowPoint[1] = targetPoint[1];
            }
        }

        return nowPoint;
    }

    private int[] startPoint(String[] park){
        int[] startPoint = {0, 0};

        for(int i = 0; i < park.length; i++){
            if(park[i].contains("S")){
                startPoint[0] = i;
                startPoint[1] = park[i].indexOf("S");
                break;
            }
        }
        return startPoint;
    }

    // 이동경로에서 이동 방향과 거리를 따로 나눠 List로 저장
    private ArrayList<String[]> nextOrder(String[] routes) {
        ArrayList<String[]> orders = new ArrayList<>();
        for(String route : routes){
            String[] order = route.split(" ");
            orders.add(order);
        }
        return orders;
    }

    // 다음 위치
    private int[] nextPoint(int y_point, int x_point, String[] order){
        String direction = order[0];
        int distance = Integer.parseInt(order[1]);
        int[] point = new int[2];
        switch (direction) {
            case "N" : point[0] = y_point - distance; point[1] = x_point; break;
            case "S" : point[0] = y_point + distance; point[1] = x_point; break;
            case "W" : point[0] = y_point; point[1] = x_point - distance; break;
            case "E" : point[0] = y_point; point[1] = x_point + distance; break;
        }
        return point;
    }

    // 다음 위치가 공원 안에 있는지 판단
    private boolean inPark(String[] park, int[] nextPoint){

        return (nextPoint[0] >= 0 && nextPoint[0] < park.length) && (nextPoint[1] >= 0 && nextPoint[1] < park[0].length());
    }

    // 장애물에 걸리지 않는가, 걸리는가. charAt으로 해보고 느리면 배열로 바꿔서 다시 시도해볼것
    private boolean noBlock(int y_point, int x_point, String[] park, String[] order){
        String direction = order[0];
        int distance = Integer.parseInt(order[1]);
        for(int i = 0; i < distance; i++){
                switch (direction) {
                    case "N" : y_point--; break;
                    case "S" : y_point++; break;
                    case "W" : x_point--; break;
                    case "E" : x_point++; break;
                } if(String.valueOf(park[y_point].charAt(x_point)).equals("X")) return false;
            } return true;
        }
}