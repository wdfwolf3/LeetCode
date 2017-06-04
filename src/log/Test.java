package log;

import java.util.Scanner;

/**
 * Created by admin on 2017/1/18.
 */
public class Test{
//    private static  final Logger LOGGER = LogManager.getLogger(Test.class.getName());
//    public static void main(String[] args) {
//        // 记录debug级别的信息
//        LOGGER.debug("This is debug message.");
//        // 记录info级别的信息
//        LOGGER.info("This is info message.");
//        // 记录warn级别的信息
//        LOGGER.warn("This is warn message.");
//        // 记录error级别的信息
//        LOGGER.error("This is error message.");
        public static void main ( String arg[] ) {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNext()){
                        String s1 = scanner.next();
                        String s2 = scanner.next();
                        String s3 = scanner.next();
                        char[][] chars = {s1.toCharArray(), s2.toCharArray(), s3.toCharArray()};
                        int x = 0, o = 0, countX = 0, countO = 0;
                        String ans = "";
                        boolean flagX = false, flagO = false;
                        for (char[] chars1 : chars){
                                x = 0;
                                o = 0;
                                for (char c : chars1){
                                        if (c == 'X'){
                                                countX++;
                                                x++;
                                        }
                                        else if(c == '0'){
                                                countO++;
                                                o++;
                                        }
                                }
                                if(x == 3)
                                        flagX = true;
                                if (o == 3)
                                        flagO = true;
                        }
                        if(countO == countX)
                                ans = "1";
                        else if(countX-countO == 1)
                                ans = "2";
                        else if(countO+countX == 9)
                                ans = "Draw";
                        else
                               ans = "x";
                        if(ans != "x"){
                                for (int i = 0; i < 3; i++) {
                                        o = 0;
                                        x = 0;
                                        for (int j = 0; j < 3; j++) {
                                                if (chars[j][i] == 'X')
                                                        x++;
                                                else if(chars[j][i] == '0')
                                                        o++;
                                        }
                                        if(x == 3){
                                                flagX = true;
                                        }
                                        if (o == 3){
                                                flagO = true;
                                        }
                                }
                        }
                        if(ans != "x"){
                                x = 0;
                                o = 0;
                                for (int i = 0; i < 3; i++) {
                                        if (chars[i][i] == 'X')
                                                x++;
                                        else if(chars[i][i] == '0')
                                                o++;
                                }
                                if(x == 3){
                                        flagX = true;
                                }
                                if (o == 3){
                                        flagO = true;
                                }
                        }
                        if(ans != "x"){
                                x = 0;
                                o = 0;
                                for (int i = 0; i < 3; i++) {
                                        if (chars[2-i][i] == 'X')
                                                x++;
                                        else if(chars[2-i][i] == '0')
                                                o++;
                                }
                                if(x == 3){
                                        flagX = true;
                                }
                                if (o == 3){
                                        flagO = true;
                                }
                        }
                        if(ans == "x")
                                System.out.println("x");
                        else if(flagO && flagX)
                                System.out.println("x");
                        else if (flagO){
                                if(ans == "2")
                                        System.out.println("x");
                                else
                                        System.out.println("2 won");
                        }
                        else if(flagX){
                                if(ans == "1")
                                        System.out.println("x");
                                else
                                        System.out.println("1 won");
                        }
                        else
                                System.out.println(ans);
                }
        }
//    }
}
