import java.util.HashMap;

public class Test {
    public static HashMap<Integer,Integer> m = new HashMap<>();
    public static void main(String[] args) {
        m.put(1,1);
        m.put(2,1);
        m.put(3,1);
        Integer t  = getValue(4);
        if (t == null){
            System.out.println("its a broken");
        }

    }

    private static Integer getValue(int i) {

        return m.get(i);
//        return 0;
    }
}
