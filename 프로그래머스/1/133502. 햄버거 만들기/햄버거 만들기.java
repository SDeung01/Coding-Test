import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int count = 0;
        Stack<Integer> bugerStk = new Stack<>();

        for(int ing_num : ingredient){
            bugerStk.push(ing_num);
            int lastIndex = bugerStk.size() - 1;
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

    private boolean canMake(Stack<Integer> bugerStk, int lastIndex){
        int layer4 = (int) bugerStk.get(lastIndex);
        int layer3 = (int) bugerStk.get(lastIndex - 1);
        int layer2 = (int) bugerStk.get(lastIndex - 2);
        int layer1 = (int) bugerStk.get(lastIndex - 3);
        return layer1 == 1 && layer2 == 2 && layer3 == 3 && layer4 == 1;
    }

    private void makeBuger(Stack<Integer> bugerStk) {
            for(int i = 0; i < 4; i++){
                bugerStk.pop();
            }
        }

}