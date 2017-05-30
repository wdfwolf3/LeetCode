import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/5/22.
 */
public class FractionAdditionandSubtraction {
    public static void main(String[] args) {
        String string  = "1/3-1/2";
        System.out.println(5%(-3));
        System.out.println(new FractionAdditionandSubtraction().fractionAddition(string));
    }
    public String fractionAddition(String expression) {
        int flag = 1, numerator = 0, denominator;
        int ans = 0, numeratorSum = 0, denominatorSum = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c=='-')
                flag = -1;
            else if(c=='+')
                flag = 1;
            else if(c=='/'){
                int end = i++;
                while(++end< expression.length() && Character.isDigit(expression.charAt(end)));
                denominator = Integer.parseInt(expression.substring(i, end));
                if(!map.containsKey(denominator)){
                    denominatorSum *= denominator;
                    map.put(denominator, numerator*flag);
                }else
                    map.put(denominator, map.get(denominator)+numerator*flag);
                i = end - 1;
            }else{
                int end = i;
                while(++end< expression.length() && Character.isDigit(expression.charAt(end)));
                numerator = Integer.parseInt(expression.substring(i, end));
                i = end - 1;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()!=0){
                numeratorSum += entry.getValue()*(denominatorSum/entry.getKey());
            }
        }
        if(numeratorSum == 0)
            return "0/1";
        int common = Math.abs(getCommon(numeratorSum, denominatorSum));
        numeratorSum /= common;
        denominatorSum /= common;
        return "" + numeratorSum + "/" + denominatorSum;
    }

    private int getCommon(int numeratorSum, int denominatorSum){
        int m = Math.max(numeratorSum, denominatorSum);
        int n = Math.min(numeratorSum, denominatorSum);
        while (m%n!=0 && n!=1){
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return n;
    }
}
