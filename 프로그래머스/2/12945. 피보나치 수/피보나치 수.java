import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> numberList = new ArrayList<>();
        // 피보나치 수를 담은 리스트를 만들고 n번째 값을 구한다.
        for(int i = 0; i <= n; i++){
            numberList.add(makeFibonacci(numberList, i));
        }
        return numberList.get(n);
    }
    private int makeFibonacci (List<Integer> numberList, int n){
        // 제한조건 상 n은 2이상의 값이므로 별도의 조건문은 사용하지 않는다.
        if(n <= 1){ return n; }
        else { return (numberList.get(n-1) + numberList.get(n-2)) % 1234567; }
    }
}