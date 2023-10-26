class Solution {
    public String solution(String phone_number) {
        int cropIdx = phone_number.length()-4;
        String stars = "*".repeat(cropIdx);
        return stars + phone_number.substring(cropIdx);
    }
}