import java.io.*;

public class Tmp {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("/home/wdf/tmp.txt")));
        System.out.println(dataInputStream.read());
    }
}
