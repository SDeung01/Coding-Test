import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int max = 0;
        
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> giftPoint = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();
        
        for(String record : gifts){
            String[] friendArr = record.split(" ");
            String from = friendArr[0];
            String to = friendArr[1];
            
            giftPoint.put(from, giftPoint.getOrDefault(from, 0) + 1);
            giftPoint.put(to, giftPoint.getOrDefault(to, 0) - 1);
            
            recordMap.put(record, recordMap.getOrDefault(record, 0) + 1);
        }
        
        for(int i = 0; i < friends.length; i++){
            for(int j = i + 1; j < friends.length; j++){
                String friendA = friends[i];
                String friendB = friends[j];
                
                int recordA = recordMap.getOrDefault(friendA + " " + friendB, 0);
                int recordB = recordMap.getOrDefault(friendB + " " + friendA, 0);
                
                if(recordA > recordB){
                    nextMonthGifts.put(friendA, nextMonthGifts.getOrDefault(friendA, 0) + 1);
                }else if(recordA < recordB){
                    nextMonthGifts.put(friendB, nextMonthGifts.getOrDefault(friendB, 0) + 1);
                }else {
                    int giftPointA = giftPoint.getOrDefault(friendA, 0);
                    int giftPointB = giftPoint.getOrDefault(friendB, 0);
                    
                    if(giftPointA > giftPointB){
                        nextMonthGifts.put(friendA, nextMonthGifts.getOrDefault(friendA, 0) + 1);
                    }else if(giftPointA < giftPointB){
                        nextMonthGifts.put(friendB, nextMonthGifts.getOrDefault(friendB, 0) + 1);
                    }
                }
            }
        }
        
        for(String friend : friends){
            int nextGifts = nextMonthGifts.getOrDefault(friend, 0);
            if(nextGifts > max) max = nextGifts;
        }
        
        return max;
    }
}