import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        // 참석이 가능한 학생들을 등수가 높은 순서대로 정렬
        List<Student> attendList = IntStream.range(0,rank.length)
                .mapToObj(id -> new Student(id, rank[id], attendance[id]))
                .filter(student -> student.isAttendance() == true)
                .sorted(Comparator.comparing(student -> student.getRank()))
                .collect(Collectors.toList());
        
        //정렬한 학생들 중 1~3등의 학생번호를 각 변수에 저장
        int a = attendList.get(0).getId();
        int b = attendList.get(1).getId();
        int c = attendList.get(2).getId();

        return 10000 * a + 100 * b + c;
    }
}

//학생번호, 등수, 참석여부를 매개변수로 받아 멤버변수로 가지는 학생 클래스
class Student {
    int id;
    int rank;
    boolean attendance;

    public Student(int id, int rank, boolean attendance) {
        this.id = id;
        this.rank = rank;
        this.attendance = attendance;
    }

    public int getId() { return id; }

    public int getRank() { return rank; }

    public boolean isAttendance() { return attendance; }
    
}