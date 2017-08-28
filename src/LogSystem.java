import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wdfwolf3 on 2017/6/25.
 */
public class LogSystem {
    private Map<Integer, String> map;
    private Map<String, String> format;


    public LogSystem() {
        map = new HashMap<>();
        format = new HashMap<>();
        format.put("Year", "yyyy");
        format.put("Month", "yyyy:MM");
        format.put("Day", "yyyy:MM:dd");
        format.put("Hour", "yyyy:MM:dd:HH");
        format.put("Minute", "yyyy:MM:dd:HH:mm");
        format.put("Second", "yyyy:MM:dd:HH:mm:ss");
    }

    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> list = new ArrayList<>();
        long start = getTimestamp(s, gra);
        long end = getTimestamp(e, gra);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            long l = getTimestamp(entry.getValue(), gra);
            if (l >= start && l <= end)
                list.add(entry.getKey());
        }
        return list;
    }

    private long getTimestamp(String s, String gra) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.get(gra));
        Long l = 0l;
        try {
            Date d = sdf.parse(s);
            l = d.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l;
    }
}
