class Solution {
    public int solution(String s) {
        int counter = 0;
        String crop = s;
        String str = "";
        while (!str.equals(crop) && !crop.equals("")){
            str = crop;
            crop = cropStr(str);
            counter++;
        }
        
        return counter;
    }
    
    private String cropStr(String str){
        char firstCh = str.charAt(0);
        int sameCnt = 0;
        int diffCnt = 0;
        for(char ch : str.toCharArray()){
            if(ch == firstCh) sameCnt++;
            else diffCnt++;
            if(sameCnt == diffCnt)
                return str.substring(sameCnt + diffCnt);
        }
        return str;
    }
}