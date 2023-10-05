class Solution {

    public int solution(int a, int b) {
        int denom = b / gcd(a, b); // 기약분수 상태에서의 분모
        int answer = 0;

        // 분모의 소인수가 2 또는 5 인지 확인하는 것으로 유한소수인지 판별
        while (answer == 0) {
            if (denom % 2 == 0) denom /= 2;
            else if (denom % 5 == 0) denom /= 5;

            answer = denom == 1 ? 1 :
                    denom % 2 != 0 && denom % 5 != 0 ? 2 : 0;
        }
        return answer;
    }

    // 최대 공약수를 구하는 메소드
    public int gcd(int num1, int num2) {
        int divisor = 1;
        // 가분수의 형태일수도 있으므로 분수와 분모 중 작은 수에서 뺀다.
        for (int i = Math.min(num1, num2); i >= 2; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                num1 /= i;
                num2 /= i;
                divisor *= i;
            }
        }
        return divisor;
    }
}