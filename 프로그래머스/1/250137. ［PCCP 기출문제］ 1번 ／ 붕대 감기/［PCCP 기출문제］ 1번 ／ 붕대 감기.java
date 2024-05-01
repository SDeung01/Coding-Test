import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        
        int lastTurn = attacks[attacks.length -1][0];
        
        int attackNum = 0;
        int bandageSequence = 0;
        
        for(int turn = 1; turn <= lastTurn; turn++){
            int attackTurn = attacks[attackNum][0];
            int damage = attacks[attackNum][1];
            bandageSequence++;
            
            if(turn == attackTurn){
                bandageSequence = 0;
                hp = hp - damage;
                if(hp <= 0){
                    return -1;
                }
                attackNum++;
            }else {
                hp = hp + bandage[1];
                
                if(bandageSequence == bandage[0]){
                    hp = hp + bandage[2];
                    bandageSequence = 0;
                }
                
                hp = hp < health ? hp : health;
            }
        }
        
        return hp;
    }
}