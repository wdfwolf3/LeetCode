/**
 * Created by wdfwolf3 on 2017/5/22.
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double length1 = equal(p1,p2,p3,p4);
        if(length1==0)
            return false;
        double length2 = equal(p1,p3,p2,p4);
        if(length2==0)
            return false;
        double length3 = equal(p1,p4,p2,p3);
        if(length3==0)
            return false;
        if(length1 > length2 && length2 == length3){
            return length1==length2*2;
        }else if(length1 == length2){
            return length3==length2*2;
        }else if (length1 < length2 && length1 == length3){
            return length2==length1*2;
        }
        return false;
    }

    public double equal(int[] p1, int[] p2, int[] p3, int[] p4){
        double d1 = Math.pow(p1[0]-p2[0], 2)+Math.pow(p1[1]-p2[1],2);
        double d2 = Math.pow(p3[0]-p4[0], 2)+Math.pow(p3[1]-p4[1],2);
        return (d1==d2)?d1:0;
    }
}
