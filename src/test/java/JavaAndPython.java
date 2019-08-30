import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaAndPython {

    public static void main(String[] args) {
        int a = 18;
        int b = 23;
        try {
            String[] args1 = new String[] { "python", "D:\\IdeaProject\\dp_SpringBoot\\src\\test\\java\\add.py", String.valueOf(a), String.valueOf(b) };
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}