import java.util.Iterator;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/5/9.
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        init(nestedList);
    }

    private void init(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else{
                init(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index!=list.size();
    }
}


