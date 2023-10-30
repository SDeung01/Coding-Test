import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();
        
        for(int i = 0; i < wallpaper.length; i++){
            if(wallpaper[i].contains("#")){
                listX.add(i);
                listY.add(wallpaper[i].indexOf("#"));
                if(wallpaper[i].indexOf("#") != wallpaper[i].lastIndexOf("#")){
                    listY.add(wallpaper[i].lastIndexOf("#"));
                }
            }
        }
        Collections.sort(listX);
        Collections.sort(listY);
        int[] answer = {listX.get(0), listY.get(0), listX.get(listX.size() - 1) + 1, listY.get(listY.size() - 1) + 1};
        return answer;
    }
}