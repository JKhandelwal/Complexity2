import java.util.Random;

public class PalindromeGenerator {
    public static Random  r = new Random();
    public static String generate(int length){
        String retString1 = "";
        String retString2 = "";
        String[] h = new String[]{"0", "1", "2"};
        if (length %2 ==0){
            for (int i =0; i < length/2;i++){
                String s = h[r.nextInt(3)];
                retString1 += s;
                retString2 = s + retString2;
            }
            return retString1 + retString2;
        } else {
            for (int i =0; i < length/2;i++) {
                String s = h[r.nextInt(3)];
                retString1 += s;
                retString2 = s + retString2;
            }
            return retString1 + h[r.nextInt(3)] + retString2;
        }
    }

    public static String generateNonPalindrome(int length){
        String retString1 = "";
        String[] h = new String[]{"0", "1", "2"};
        if (length %2 ==0){
            for (int i =0; i < length/2;i++){
                String s = h[r.nextInt(3)];
                retString1 += s;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(retString1);
            String rev = sb.reverse().toString();
            if (!rev.equals(retString1)) return retString1 + retString1;
            else return  retString1 + "0" + "1" + "2" + "0" + retString1;
        } else {
            for (int i =0; i < (length-1)/2;i++) {
                String s = h[r.nextInt(3)];
                retString1 += s;
            }
            return retString1 + "0" +"1" + "2" +retString1;
        }
    }
}
