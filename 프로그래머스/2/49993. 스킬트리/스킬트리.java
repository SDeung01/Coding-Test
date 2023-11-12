class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for(String tree : skill_trees){
            String removedSkill = remove(skill, tree);
            // 선행스킬을 아무것도 익히지 않은 경우도 카운트
            if(removedSkill.isEmpty()) {
                count++;
                continue;
            }
            if(skill.indexOf(removedSkill) == 0) {
                count++;
            }
        }        
        return count;
    }
    
    // 선행스킬 외의 스킬들을 스킬트리에서 모두 제거
    private String remove(String skill, String skill_tree){
        return skill_tree.replaceAll("[^" + skill + "]","");
    }
}