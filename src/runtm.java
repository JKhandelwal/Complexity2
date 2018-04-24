import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;


public class runtm {
    private static HashMap<String, TMState> listOfStates= new HashMap<>();
    private static String currentState;
    private static String initialState;
    private static boolean initialStateSet = false;

    public static void main(String[] args) {
        File f1 = new File("file1.txt");
        File f2 = new File("input.txt");
        String line;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f1));
            line = br.readLine();
            String[] split = line.split(" ");
            if (!split[0].equals("States")) {
                System.out.println("Invalid usage ");
                System.exit(0);
            }
            int count = Integer.parseInt(split[1]);
            for (int numStates = 0; numStates < count; numStates++) {
                line = br.readLine();
                split = line.split(" ");
                TMState s;
                if (split.length == 2){
                    s = new TMState(true);
                } else s = new TMState(false);
            listOfStates.put(split[0],s);
            if (numStates ==0) initialState = split[0];
            }
            line = br.readLine();
            split = line.split(" ");
            count = Integer.parseInt(split[1]);

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
