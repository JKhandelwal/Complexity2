import java.io.*;
import java.nio.file.Files;

public class TestData {
    public static void main(String[] args) {
//        palindrome();
//        System.out.println("palindromes finished");
//        verifyAddition();
//        System.out.println("Verify Addition finished");
//        doAddition();
//        System.out.println("Do addition Done");
//        count();
//        System.out.println("Count Finished");
        TwosComplement();
        System.out.println("Count Finished");
    }


    public static void count() {
        File outputFile = new File("Files/CountMaxValue.csv");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            File input = new File("Files/InputFiles/countMoreZeros.txt");
            File desc = new File("Files/DescriptionFiles/Count.txt");
            for (long i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(input));
                    String s = Long.toBinaryString(i);
                    br.write(String.valueOf(s));
                    br.newLine();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runtm tm = new runtm(true);
                boolean b = tm.run(desc, input);
                assert b;
                out.write(tm.getLengthOfInput() + "," + tm.getNumberOfTransitions());
                out.newLine();
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TwosComplement() {
        File outputFile = new File("Files/2sComplementNumbers.csv");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            File input = new File("Files/InputFiles/TwosComplement.txt");
            File desc = new File("Files/DescriptionFiles/TwosComplement.txt");
            for (int i = 0; i < Math.pow(2,24); i++) {
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(input));
                    String s = Long.toBinaryString(i);
                    br.write(String.valueOf(s));
                    br.newLine();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runtm tm = new runtm(true);
                boolean b = tm.run(desc, input);
                assert b;
                out.write(tm.getLengthOfInput() + "," + tm.getNumberOfTransitions());
                out.newLine();
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void palindrome() {
        File outputFile = new File("Files/palindromeOutputFile.csv");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            File input = new File("Files/InputFiles/TestPalindromeAddition1.txt");
            File desc = new File("Files/DescriptionFiles/palindrome.txt");
            for (int i = 1; i < 600; i++) {
                String s = PalindromeGenerator.generate(i);
                BufferedWriter br = new BufferedWriter(new FileWriter(input));
                br.write(s);
                br.newLine();
                br.close();
                runtm tm = new runtm(true);
                boolean b = tm.run(desc, input);
                assert b;

                out.write(tm.getLengthOfInput() + "," + tm.getNumberOfTransitions());
                out.newLine();
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doAddition() {
        File outputFile = new File("Files/binaryAdditionOutputFile.csv");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            File input = new File("Files/InputFiles/binaryAddition1.txt");
            File desc = new File("Files/DescriptionFiles/BinaryAddition.txt");
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    try {
                        BufferedWriter br = new BufferedWriter(new FileWriter(input));
                        StringBuilder b = new StringBuilder();
                        String fin = "";

                        String s = Long.toBinaryString((long) Math.pow(i, 2));
                        b.append(s);
                        fin += (b.reverse()).toString() + "#";
                        b.setLength(0);

                        s = Long.toBinaryString((long) Math.pow(j, 2));
                        b.append(s);
                        fin += (b.reverse()).toString() + "#";
                        b.setLength(0);

                        s = Long.toBinaryString((long) Math.pow(i, 2) + (long) Math.pow(j, 2));
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
                    boolean b = tm.run(desc, input);
                    assert b;
                    out.write(tm.getLengthOfInput() + "," + tm.getNumberOfTransitions());
                    out.newLine();
                    out.flush();
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verifyAddition() {
        File outputFile = new File("Files/verifyAdditionOutputFile.csv");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            File input = new File("Files/InputFiles/TestVerifyAddition1.txt");
            File desc = new File("Files/DescriptionFiles/VerifyAddition.txt");

            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    try {
                        BufferedWriter br = new BufferedWriter(new FileWriter(input));
                        StringBuilder b = new StringBuilder();
                        String fin = "";

                        String s = Long.toBinaryString((long) Math.pow(i, 2));
                        b.append(s);
                        fin += (b.reverse()).toString() + "#";
                        b.setLength(0);

                        s = Long.toBinaryString((long) Math.pow(j, 2));
                        b.append(s);
                        fin += (b.reverse()).toString() + "#";
                        b.setLength(0);

                        s = Long.toBinaryString((long) Math.pow(i, 2) + (long) Math.pow(j, 2));
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
                    boolean b = tm.run(desc, input);
                    assert b;
                    out.write(tm.getLengthOfInput() + "," + tm.getNumberOfTransitions());
                    out.newLine();
                    out.flush();
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
