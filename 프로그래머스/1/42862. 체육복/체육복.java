import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> reserveList = new ArrayList();
        List<Integer> lostList = new ArrayList();
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int reserveId : reserve){
            reserveList.add(reserveId);
        }
        for(int lostId : lost){
            lostList.add(lostId);
        }
        System.out.println(lostList);
        for(int lostId : lost){
            rentalSelf(lostList, reserveList, lostId);
        }
        System.out.println(lostList);
        for(int lostId : lost){
            rental(lostList, reserveList, lostId);
        }
        System.out.println(lostList);
        return n - lostList.size();
    }

    private void rental(List lostList, List reserveList, int id){
        int prevId = id - 1;
        int nextId = id + 1;
        if(reserveList.contains(prevId)){
            reserveList.remove(Integer.valueOf(prevId));
            lostList.remove(Integer.valueOf(id));
        } else if(reserveList.contains(nextId)){
            reserveList.remove(Integer.valueOf(nextId));
            lostList.remove(Integer.valueOf(id));
        }
    }
    
    private void rentalSelf(List lostList, List reserveList, int id){
        if(reserveList.contains(id)){
            reserveList.remove(Integer.valueOf(id));
            lostList.remove(Integer.valueOf(id));
        }
    }
}

// import java.util.*;
// class Solution {
//     public int solution(int n, int[] lost, int[] reserve) {
//         int answer = 0;
        
//         answer = n -lost.length;
//         Arrays.sort(lost);
//         Arrays.sort(reserve);
//         for(int i=0; i<lost.length; i++){
//             for(int j =0; j<reserve.length; j++){
//                 if(lost[i] == reserve[j]){
//                     answer++;
//                     lost[i] = -1;
//                     reserve[j] = -1;
//                 }
//             }
//         }
//         for(int i=0; i<lost.length; i++){
//             for(int j =0; j<reserve.length; j++){
//                 if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1 ){
//                     answer++;
//                     lost[i] = -1;
//                     reserve[j] = -1;
//                 }
//             }
//         }
//         System.out.println(Arrays.toString(lost));
//         return answer;
//     }
// }