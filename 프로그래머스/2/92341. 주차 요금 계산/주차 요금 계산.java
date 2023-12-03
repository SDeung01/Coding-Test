import java.util.*;

class Solution {
    class Car{
        private int in = 0;
        private int out = 0;
        private int totalTime = 0;
        private boolean entry = false;
        
        public Car(){};
    }
    
    public int[] solution(int[] fees, String[] records) {
        String[][] recordArr = new String[records.length][3];
        Map<String, Car> carMap = new HashMap<>();
        int idx = 0;
        
        for(String recordStr : records){
            recordArr[idx++] = recordStr.split(" ");
        }
        
        for(String[] record : recordArr){
            int time = convertTime(record[0]);
            String carNum = record[1];
            String inAndOut = record[2];
            
            Car car;
            
            if(carMap.containsKey(carNum)){
                car = carMap.get(carNum);
            }else {
                car = new Car();
            }
            
            if(inAndOut.equals("IN")){
                car.in = time;
                car.entry = true;
                carMap.put(carNum, car);
            }else if(inAndOut.equals("OUT")){
                car.out = time;
                car.totalTime += car.out - car.in;
                car.entry = false;
                carMap.put(carNum, car);
            }
        }
        
        // 23:59 까지 출차 안된 차량
        for(String carNum : carMap.keySet()){
            Car car = carMap.get(carNum);
            if(car.entry){
                int outTime = convertTime("23:59");
                car.totalTime += outTime - car.in;
                carMap.put(carNum, car);
            }
        }
        
        List<String> keySet = new ArrayList<>(carMap.keySet());
        Collections.sort(keySet);
        
        int[] result = new int[carMap.size()];
        idx = 0;
        for(String key : keySet){
            Car car = carMap.get(key);
            int totalTime = car.totalTime;
            result[idx++] = calculate(fees, totalTime);
        }
        
        return result;
    }
    
    private int convertTime(String timeStr){
        String[] timeArr = timeStr.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int min = Integer.parseInt(timeArr[1]);
        
        return hour*60 + min;
    }
    
    private int calculate(int[] fees, int time){
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(time <= basicTime) return basicFee;
        else{
            return basicFee + (int) Math.ceil((double)(time - basicTime) / unitTime) * unitFee;
        }
    }
}