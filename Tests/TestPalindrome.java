import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class TestPalindrome {

    @Test
    public void TestOne() {
        File f1 = new File("Files/InputFiles/TestPalindrome1.txt");
        File f2 = new File("Files/palindrome.txt");
        for (int i = 0; i < 3; i++) {
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter(f1));
                br.write(String.valueOf(i));
                br.newLine();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            runtm tm = new runtm(false);
            assert tm.run(f2, f1);
        }
        try {
            Files.deleteIfExists(f1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestTwo() {
        File f1 = new File("Files/InputFiles/TestPalindrome2.txt");
        File f2 = new File("Files/palindrome.txt");
        for (int i = 2; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(f1));
                    String s = PalindromeGenerator.generate(i);
                    br.write(s);
                    br.newLine();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runtm tm = new runtm(true);
                assert tm.run(f2, f1);
            }
        }
        try {
            Files.deleteIfExists(f1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestThree() {
        File f1 = new File("Files/InputFiles/TestPalindrome3.txt");
        File f2 = new File("Files/palindrome.txt");
        for (int i = 2; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                String s= "";
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(f1));
                    s = PalindromeGenerator.generateNonPalindrome(i);
                    br.write(s);
                    br.newLine();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runtm tm = new runtm(true);
                if  (tm.run(f2, f1)) System.out.println(s);;
            }
        }
    }

}
