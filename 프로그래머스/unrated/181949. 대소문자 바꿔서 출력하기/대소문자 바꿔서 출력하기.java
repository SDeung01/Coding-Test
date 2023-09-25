import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++){
            int charToInt = (int) charArray[i];
            if((charToInt >= 97) && (charToInt <= 122)){
                charArray[i] = (char)(charToInt - 32); 
            } else if((charToInt >= 65) && (charToInt <= 90)){
                charArray[i] = (char)(charToInt + 32);
            }
        }
        String answer = String.valueOf(charArray);
        System.out.print(answer);
    }
}