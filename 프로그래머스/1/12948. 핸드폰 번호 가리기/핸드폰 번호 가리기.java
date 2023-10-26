// class Solution {
//     public String solution(String phone_number) {
//         int cropIdx = phone_number.length()-4;
//         String stars = "*".repeat(cropIdx);
//         return stars + phone_number.substring(cropIdx);
//     }
// }

class Solution {
    public String solution(String phone_number) {
        int cropIdx = phone_number.length()-4;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cropIdx; i++){
            sb.append("*");
        }
        return sb.append(phone_number.substring(cropIdx)).toString();
    }
}