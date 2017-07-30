import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wdfwolf3 on 2017/6/25.
 */
public class Main {
    public static void main(String[] args) {
        String s = "2017:01:01:23:59:52";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH");
        Long l = 0l;
        try {
            Date d = sdf.parse(s);
            l = d.getTime();
            System.out.println(l);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
