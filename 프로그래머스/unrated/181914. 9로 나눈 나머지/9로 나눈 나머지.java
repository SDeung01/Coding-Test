import java.util.stream.IntStream;

class Solution {
    public int solution(String number) {
        int digitSum = IntStream.range(0,number.length())
                .map(i -> Character.getNumericValue(number.charAt(i)))
                .sum();
        return digitSum % 9;
    }
}