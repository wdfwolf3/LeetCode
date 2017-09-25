import java.util.ArrayList;
import java.util.List;


public class Fizz_Buzz {
    public static void main(String args[]) {
        System.out.println(fizzBuzz(16));
    }

    public static List<String> fizzBuzz(int n) {
        String THREE = "Fizz";
        String FIVE = "Buzz";
        String FIFETEEN = "FizzBuzz";
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if ((i % 15) == 0)
                list.add(FIFETEEN);
            else if ((i % 3) == 0)
                list.add(THREE);
            else if ((i % 5) == 0)
                list.add(FIVE);
            else {
                list.add(Integer.toString(i));
            }

        }
        return list;
    }
}
