package javabasiccourse.inputoutput.ansi_to_utf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buf = {48, 49, 50, 51};
        ByteArrayInputStream arr = new ByteArrayInputStream(buf);
        String result = readAsString(arr, Charset.forName("US-ASCII"));
        System.out.println(result);
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        char[] buf = new char[4096];
        int nSize;
        StringBuilder stringBuilder = new StringBuilder(0);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        nSize = inputStreamReader.read(buf);
        for (int i = 0; i < nSize; i++) {
            stringBuilder.append(buf[i]);
        }
        return stringBuilder.toString();
    }
}
