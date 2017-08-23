/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class StudentAttendanceRecordI {
    public static void main(String[] args) {
        System.out.println("PPAPPA".split("A").length);
    }

    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                if (countA > 0)
                    return false;
                countA++;
            }
        }
        return !s.contains("LLL");
    }
}
