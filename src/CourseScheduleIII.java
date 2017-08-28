import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wdfwolf3 on 2017/6/27.
 */
public class CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1] ? 0 : (o1[1] < o2[1] ? -1 : 1));
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int sum = 0;
        for (int[] course : courses) {
            sum += course[0];
            queue.offer(course[0]);
            if (sum > course[1])
                sum -= queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] ints = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(ints));
    }
}
