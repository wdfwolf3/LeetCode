import java.util.*;


public class FourSum {


    public static void main(String args[]) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum1(nums, 0));
    }


    public static List<List<Integer>> fourSum1(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num.length < 4) {
            return res;
        }
        Arrays.sort(num);
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                Pair pair = new Pair(num[i], i, num[j], j);
                int sum = num[i] + num[j];
                List<Pair> list;
                if (map.containsKey(sum)) {
                    list = map.get(sum);
                } else {
                    list = new ArrayList<>();
                    map.put(sum, list);
                }
                list.add(pair);
            }
        }
        Integer first = map.firstKey();
        Integer last = map.lastKey();
        while (first != null && last != null && first <= last) {
            if (first + last > target) {
                last = map.lowerKey(last);
            } else if (first + last < target) {
                first = map.higherKey(first);
            } else if (first == last) {
                List<Pair> list = map.get(first);
                for (int i = 0; i < list.size(); i++) {
                    Pair a = list.get(i);
                    if (a.a == a.b) {
                        for (int j = i + 1; j < list.size(); j++) {
                            Pair b = list.get(j);
                            if (b.a == b.b) {
                                if (a.bi < b.ai) {
                                    res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        break;
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            } else {
                Pair lastA = null;
                for (Pair a : map.get(first)) {
                    if (a.same(lastA)) {
                        continue;
                    }
                    lastA = a;
                    Pair lastB = null;
                    for (Pair b : map.get(last)) {
                        if (a.bi < b.ai) {            //����ȥ��
                            if (b.same(lastB)) {
                                continue;
                            }
                            lastB = b;
                            res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                        }
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
        }
        return res;
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j < (nums.length - 1) && nums[j] == nums[j + 1])
                    continue;
                int key = nums[i] + nums[j];
                List<List<Integer>> lists = new ArrayList<>();
                lists.add(Arrays.asList(nums[i], nums[j]));
                if (map.get(key) != null)
                    lists.addAll(map.get(key));
                map.put(key, lists);
            }
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
            if (map.containsKey(target - entry.getKey())) {
                List<List<Integer>> list1 = entry.getValue();
                List<List<Integer>> list2 = map.get(target - entry.getKey());
                for (List<Integer> l1 : list1) {
                    for (List<Integer> l2 : list2) {
                        List<Integer> list = new ArrayList<>(l1);
                        list.addAll(l2);
                        lists.add(list);
                    }
                }
                //       		map.remove(target-entry.getKey());
//        		map.remove(entry);
            }


        }
        return lists;
    }
}

class Pair {
    int a;
    int ai;
    int b;
    int bi;

    public Pair(int a, int ai, int b, int bi) {
        this.a = a;
        this.ai = ai;
        this.b = b;
        this.bi = bi;
    }

    boolean same(Pair p) {
        return p != null && p.a == a && p.b == b;
    }
}
