import java.io.*;

public class Lab6_var7 {
    public static String[] words;
    public static boolean getLine(char w)
    {
        StringBuilder sb = new StringBuilder();
        for (String word : words)
        {
            if(word.charAt(0) == word.charAt(word.length()-1))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;
        OutputStream out = null;
        Writer wr = null;
        try {
            in = new FileInputStream("C:\\Users\\123\\MyFile1.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);
            File f1 = new File("C:\\Users\\123\\MyFile2.txt");
            f1.createNewFile();
            if (f1.exists()) {
                out = new FileOutputStream(f1);
                wr = new OutputStreamWriter(out, "Unicode");
                String line = "";

                int num_line = 1;
                while ((line = buf.readLine()) != null) {
                    wr.write(num_line);
                    words = line.split(" ");
                    int count = 0;

                    for (int i = 0; i < words.length; i++) {
                        if (getLine(words[i].charAt(0))) {
                            wr.append(words[i] + " ");
                            count++;
                        }
                    }
                    wr.append(count + "\n");
                }
            }
        }
        catch (IOException ie) {
            System.out.println("Error " + ie);
        }
        finally {
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}
