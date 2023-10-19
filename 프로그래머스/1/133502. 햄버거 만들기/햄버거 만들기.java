import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int count = 0;
        Stack<Integer> bugerStk = new Stack<>();

        for(int ing_num : ingredient){
            bugerStk.push(ing_num);
            int lastIndex = bugerStk.size() - 1;
            // 재료가 최소 4개는 있어야 버거를 만들 수 있다.
            if(bugerStk.size() >= 4){
                boolean check = canMake(bugerStk, lastIndex);
                if(check) {
                    makeBuger(bugerStk);
                    count++;
                }
            }
        }
        return count;
    }

    // 재료더미(스택)의 가장 위에 있는 재료부터 4개를 확인하여 적절한 재료라면 버거를 만들 수 있는지 여부를 반환한다.
    private boolean canMake(Stack<Integer> bugerStk, int lastIndex){
        int layer4 = (int) bugerStk.get(lastIndex);
        int layer3 = (int) bugerStk.get(lastIndex - 1);
        int layer2 = (int) bugerStk.get(lastIndex - 2);
        int layer1 = (int) bugerStk.get(lastIndex - 3);
        return layer1 == 1 && layer2 == 2 && layer3 == 3 && layer4 == 1;
    }

    // 버거를 만들기 위해 재료더미(스택)에서 재료 4개를 빼간다.
    private void makeBuger(Stack<Integer> bugerStk) {
            for(int i = 0; i < 4; i++){
                bugerStk.pop();
            }
        }

}