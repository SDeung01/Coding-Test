class Solution {
    public int solution(int chicken) {
        // 시켜먹은 치킨 수 만큼 받은 쿠폰으로 1차 서비스를 받았다고 가정
        int service = chicken / 10; // 서비스(1차)
        int coupon = service + (chicken % 10); // 1차 서비스로 받은 쿠폰 포함, 남은 쿠폰
        while(coupon / 10 != 0){
            int addService = 0; // 2차 이후로 추가되는 서비스 
            addService = coupon / 10;
            coupon = coupon % 10 + addService; // 2차 이후로 남은 쿠폰
            service += addService;
        }
        return service;
    }
}