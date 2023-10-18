import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack> machine = set_machine(board);
        Stack<Integer> basket = new Stack<>();
        int count = 0;
        for(int line_num : moves){
            int select_doll = select(machine, line_num);
            int last_doll = basket.empty() ? 0 : basket.peek();  // 빈바구니면 마지막으로 뽑은 인형은 없다(0)
            if(select_doll != 0) {          // 바구니 스택에 뽑은 인형을 쌓고, 같은 인형이면 삭제
                basket.push(select_doll);
                if(select_doll == last_doll){
                    basket.pop();
                    basket.pop();
                    count += 2;
                }
            }
        }

        return count;
    }

    // 인형뽑기의 세로 한 라인을 하나의 스택으로 생성
    // 인형이 있을때(!0)만 스택에 저장
    private List<Stack> set_machine(int[][] board){
        List<Stack> machine = new ArrayList<>();
        for(int x = 0; x < board.length; x++){
            Stack<Integer> line = new Stack<>();
            for(int y = board.length - 1; y >= 0; y--){
                if(board[y][x] != 0) { line.push(board[y][x]); }
                else { break; }
            } machine.add(line);
        } return machine;
    }

    // moves의 원소를 받아와 원하는 라인(스택)의 맨 위에 있는 인형을 뽑음(pop)
    // 만약 그 라인에 뽑을 인형이 없다면(스택이 비어있다면) 0을 반환
    private int select(List<Stack> machine, int line_num){
        Stack<Integer> line = machine.get(line_num - 1);
        return line.empty() ? 0 : line.pop();
    }

}