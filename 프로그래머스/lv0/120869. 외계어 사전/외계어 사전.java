class Solution {
    public int solution(String[] spell, String[] dic) {
        // 외계어 사전에서 한단어씩 꺼내서 배열의 알파벳과 하나씩 비교
        for(String str : dic){
            int count = 0;
            for(int i = 0; i < spell.length; i++){
                // 사전의 단어에 배열의 알파벳이 존재할 경우 count가 증가
                if(str.indexOf(spell[i]) > -1){
                    // // 만약 단어에 배열의 알파벳이 둘 이상 존재할 경우 2 반환
                    // if(str.indexOf(spell[i]) != str.lastIndexOf(spell[i])){
                    //     return 2;
                    // } 
                    count++;
                }
            // 카운트와 단어의 길이가 일치할 경우 1 반환
            } if(count == spell.length) {
                return 1;
            }
        }
        return 2;
    }
}