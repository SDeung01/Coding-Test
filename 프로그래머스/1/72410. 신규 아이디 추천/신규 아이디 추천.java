import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public String solution(String new_id) {
        // 소문자,0~9,-_. 으로 구성된 3~15자 문자열, 시작과 끝에 마침표(.)를 사용하지 않음
        String regex1 = "^(?!\\.)[a-z0-9-_.]{3,15}(?<!\\.)$";
        // 마침표가 두자리 이상 이어짐
        String regex2 = "^.*(\\.){2,}.*$";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher1 = pattern1.matcher(new_id);
        Matcher matcher2 = pattern2.matcher(new_id);

        // 패턴1이 true, 패턴2가 false면 주어진 new_id 그대로 출력
        if(matcher1.matches() && !matcher2.matches()){
            return new_id;
        } else {
            // 문자열에 대문자가 존재할 경우 소문자로 치환
            if(Pattern.matches("^.*[A-Z]+.*$",new_id)){
                new_id = new_id.toLowerCase();
            }
            // 문자열에 소문자,숫자,-_. 를 제외한 문자가 있다면 모두 제거
            if(!Pattern.matches("[a-z0-9-_.]+",new_id)){
                new_id = new_id.replaceAll("[^a-z0-9-_.]","");
            }
            // 문자열에 마침표(.)가 연속되어 사용된다면 하나의 마침표로 치환
            if(Pattern.matches("^.*(\\.){2,}.*$",new_id)){
                new_id = new_id.replaceAll("(\\.){2,}","\\.");
            }
            // 문자열이 마침표(.)로 시작하면 제거
            if(Pattern.matches("^(?=\\.).+",new_id)){
                new_id = new_id.substring(1);
            }
            // 문자열이 마침표(.)로 끝나면 제거
            if(Pattern.matches(".+(?<=\\.)$",new_id)){
                new_id = new_id.substring(0,new_id.length()-1);
            }
            // 문자열이 비었다면 "a" 대입
            if(new_id.isEmpty()){
                new_id = "a";
            }
            // 문자열이 16자 이상이면 15번째 자리 이후 제거, 제거 후 문자열이 마침표(.)로 끝나면 마침표 제거.
            if(new_id.length() >= 16){
                if(new_id.charAt(14) == '.'){
                    new_id = new_id.substring(0,14);
                }else {
                    new_id = new_id.substring(0,15);
                }
            }
            // 문자열이 2자 이하면 문자열의 길이가 3이 될 때 까지 마지막 문자 반복
            if(new_id.length() <= 2){
                char lastCh = new_id.charAt(new_id.length()-1);
                while (new_id.length() < 3){
                    new_id += lastCh;
                }
            }

            return new_id;
        }
    }
}