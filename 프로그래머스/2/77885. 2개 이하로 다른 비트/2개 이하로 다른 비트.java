class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            long number = numbers[i];
            String bitNum = Long.toBinaryString(number);
            int bitNumCnt = Long.bitCount(number);
            long nextNum = 0;
            StringBuilder sb =  new StringBuilder();
            if(bitNum.length() == bitNumCnt){
                sb = sb.append("0").append(bitNum);
                sb.setCharAt(1, '0');
                sb.setCharAt(0, '1');
                nextNum = Long.parseLong(sb.toString(),2);
            }else {
                sb = sb.append(bitNum);
                int lastZeroIdx = bitNum.lastIndexOf('0');
                sb.setCharAt(lastZeroIdx,'1');
                if(lastZeroIdx < bitNum.length() - 1){
                    sb.setCharAt(lastZeroIdx +1,'0');
                }
                nextNum = Long.parseLong(sb.toString(),2);
            }
            answer[i] = nextNum;
        }
        return answer;
    }
}