import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/11.
 */
public class StringIterator {
    private List<Character> charList = new ArrayList<>();
    private List<Integer> numList = new ArrayList<>();
    private int index = 0;
    private boolean hasNext;

    public static void main(String[] args) {
        String s = "L1e2t1C1o1d1e1";
        StringIterator stringIterator = new StringIterator(s);
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());

        System.out.println(stringIterator.hasNext());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.hasNext());
        System.out.println(stringIterator.next());
    }

    public StringIterator(String compressedString) {
        if (compressedString.length() != 0) {
            hasNext = true;
            int last = 1;
            for (int i = 1; i < compressedString.length(); i++) {
                if (Character.isAlphabetic(compressedString.charAt(i))) {
                    charList.add(compressedString.charAt(last - 1));
                    numList.add(Integer.parseInt(compressedString.substring(last, i)));
                    last = i + 1;
                }
            }
            charList.add(compressedString.charAt(last - 1));
            numList.add(Integer.parseInt(compressedString.substring(last)));
        }
    }

    public char next() {
        if (hasNext) {
            char c = charList.get(index);
            if (numList.get(index) == 1) {
                if (index == numList.size() - 1) {
                    hasNext = false;
                } else
                    index++;
            } else
                numList.set(index, numList.get(index) - 1);
            return c;
        } else {
            return ' ';
        }
    }

    public boolean hasNext() {
        return hasNext;
    }
}
