import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class TestVerifyAddition {


    @Test
    public void TestOne() {
        File f1 = new File("Files/InputFiles/TestVerifyAddition1.txt");
        File f2 = new File("Files/DescriptionFiles/VerifyAddition.txt");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(f1));
                    StringBuilder b = new StringBuilder();
                    String fin = "";

                    String s = Long.toBinaryString(i);
                    b.append(s);
                    fin += (b.reverse()).toString() + "#";
                    b.setLength(0);

                    s = Long.toBinaryString(j);
                    b.append(s);
                    fin += (b.reverse()).toString() + "#";
                    b.setLength(0);

                    s = Long.toBinaryString(j + i);
                    b.append(s);
                    fin += (b.reverse()).toString();
                    b.setLength(0);

                    br.write(String.valueOf(fin));
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
    public void TestTwo() {
        File f1 = new File("Files/InputFiles/TestVerifyAddition2.txt");
        File f2 = new File("Files/DescriptionFiles/VerifyAddition.txt");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(f1));
                    StringBuilder b = new StringBuilder();
                    String fin = "";

                    String s = Long.toBinaryString(i);
                    b.append(s);
                    fin += (b.reverse()).toString() + "#";
                    b.setLength(0);

                    s = Long.toBinaryString(j);
                    b.append(s);
                    fin += (b.reverse()).toString() + "#";
                    b.setLength(0);

                    s = Long.toBinaryString(j + i + 1);
                    b.append(s);
                    fin += (b.reverse()).toString();
                    b.setLength(0);

                    br.write(String.valueOf(fin));
                    br.newLine();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runtm tm = new runtm(true);
                assert !tm.run(f2, f1);
            }
        }
        try {
            Files.deleteIfExists(f1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dothing() {
        File f1 = new File("Files/InputFiles/TestVerifyAddition2.txt");
        File f2 = new File("Files/DescriptionFiles/BinaryAddition.txt");
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(f1));
            StringBuilder b = new StringBuilder();
            String fin = "";
            fin += "010#101";
            br.write(String.valueOf(fin));
            br.newLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        runtm tm = new runtm(true);
        assert tm.run(f2, f1);
        System.out.println(tm.getNumberOfTransitions() + " " + tm.getLengthOfInput());
        try {
            Files.deleteIfExists(f1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
