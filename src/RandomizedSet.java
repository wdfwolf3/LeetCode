import java.util.*;

/**
 * Created by wdfwolf3 on 2017/6/19.
 */
public class RandomizedSet {
    private Map<Integer, Integer> valueIndex;
    private List<Integer> list;
    private int index;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueIndex = new HashMap<>();
        list = new ArrayList<>();
        index = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueIndex.containsKey(val))
            return false;
        valueIndex.put(val, index++);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valueIndex.containsKey(val)){
            int tmp = valueIndex.get(val);
            valueIndex.put(list.get(index-1), tmp);
            list.set(tmp, list.get(index-1));
            valueIndex.remove(val);
            list.remove(--index);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (index == 0)
            return 0;
        Random random = new Random();
        return list.get(random.nextInt(index));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
