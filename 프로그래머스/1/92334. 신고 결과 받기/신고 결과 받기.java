import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<String[]> reportList = reportUser(report);
        ArrayList<String> banedList = banedUser(reportList, k);

        return sendingMail(id_list, reportList, banedList);
    }

    // 리포트를 가져와 중복 신고 접수를 없애고 이용자 id와 신고된 id를 구분하여 배열로 저장, 그것을 요소로 하는 리스트를 반환
    private ArrayList<String[]> reportUser(String[] report) {
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        ArrayList<String[]> reportList = new ArrayList<>();

        for (String s : reportSet) {
            String[] id = s.split(" ");
            reportList.add(id);
        }
        return reportList;
    }

    //신고된 id 중 정지 기준치를 넘긴 id를 리스트로 반환 
    private ArrayList<String> banedUser(ArrayList<String[]> reportList, int k) {
        ArrayList<String> banedId = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String[] reporter : reportList) {
            map.put(reporter[1], map.getOrDefault(reporter[1], 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) >= k) {
                banedId.add(key);
            }
        }
        return banedId;
    }

    // 이용자의 신고내역 중 정지된 id가 있으면 메일을 발송하고 그 횟수를 배열로 반환
    private int[] sendingMail(String[] id_list, ArrayList<String[]> reportList, ArrayList<String> banedList) {
        int[] sentMail = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            int mailCount = 0;
            for (String[] reporter : reportList) {
                if (userId.equals(reporter[0]) && banedList.contains(reporter[1])) {
                    mailCount++;
                }
            } sentMail[i] = mailCount;
        }
        return sentMail;
    }
}