import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Collator {
    public static HashMap<Integer,Integer> count = new HashMap<>();
    public static HashMap<Integer,Integer> values = new HashMap<>();
    public static void main(String[] args) {
        File f = new File("Files/Count1.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                int a = Integer.parseInt(split[0]);
                if (count.containsKey(a)) {
                    count.put(a, count.get(a) + 1);
                    values.put(a, values.get(a) + Integer.parseInt(split[1]));
                } else {
                    count.put(a, 1);
                    values.put(a, Integer.parseInt(split[1]));
                }
            }
            br.close();
            File toWrite = new File("Files/CollatedCountAddition1.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(toWrite));
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                bw.write(entry.getKey() + "," + (values.get(entry.getKey()) / entry.getValue()));
                bw.newLine();
            }
            bw.close();
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
