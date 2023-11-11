class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for(String tree : skill_trees){
            String removedSkill = remove(skill, tree);
            // 선행스킬을 아무것도 익히지 않은 경우도 카운트
            if(removedSkill.isEmpty()) {
                count++;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                // 선행스킬을 순서대로 하나씩 익힌 것과 removedSkill 이 일치하면 카운트
                for(char ch : skill.toCharArray()){
                    sb = sb.append(ch);
                    if(sb.toString().equals(removedSkill)){
                        count++;
                        break;
                    }
                }
            }
        }
        
        return count;
    }
    
    // 선행스킬 외의 스킬들을 스킬트리에서 모두 제거
    private String remove(String skill, String skill_tree){
        return skill_tree.replaceAll("[^" + skill + "]","");
    }
}