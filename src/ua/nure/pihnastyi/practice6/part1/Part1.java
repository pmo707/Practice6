package ua.nure.pihnastyi.practice6.part1;


import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Part1 {
    private static final String ENCODING = "CP1251";

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.setIn(new ByteArrayInputStream("asd\nasdf\nasd\nasdf\nasdf\n43\nasdsf\n43\n43\n434\nstop".getBytes(ENCODING)));
        Scanner in = new Scanner(System.in, "cp1251");
        WordContainer wc = new WordContainer();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if ("stop".equals(s)) {
                break;
            }
            wc.add(s);
        }
        wc.sort();
        in.close();
        System.out.println(wc);
    }
}
