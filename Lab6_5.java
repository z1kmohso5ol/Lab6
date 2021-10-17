import java.io.*;

public class Lab6_5 {
    public static void main(String[]args) throws IOException {
        BufferedReader br=null;
        PrintWriter out=null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C:\\MyFile1.txt"),"cp1251"));
            out = new PrintWriter("C:\\MyFile2.txt", "cp1251");
            int lineCount=0;
            String s;
            while ((s=br.readLine())!=null) {
                lineCount++;
                out.println(lineCount + ":" +s);
            }
        } catch (IOException e){
            System.out.println("Ошибка!!!");
        }
        finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
