/**
 * Created by wendefeng on 2017/1/22.
 */
public class ConstructTheRectangle {
    public static void main(String[] args) {
        int n = 1;
        ConstructTheRectangle constru = new ConstructTheRectangle();
        System.out.println(constru.constructRectangle(n)[0]+" "+constru.constructRectangle(n)[1]);
    }

    public int[] constructRectangle(int area) {
        int q = (int) Math.sqrt(area);
        if(q*q==area)
            return new int[]{q,q};
        for(q=q+1;q<=area;q++){
            if(area % q == 0)
                break;
            else
                continue;
        }
        return new int[]{q, area/q};
    }
}
