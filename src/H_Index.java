import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int i = citations.length;
        for (; i > 0; i--)
            if (citations[citations.length - i] >= i && (i > citations.length - 1 || citations[citations.length - i - 1] <= i))
                break;
        return i;
    }
}
