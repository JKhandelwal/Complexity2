import java.io.*;
import java.util.HashMap;
import java.util.HashSet;


public class runtm {
    private HashMap<String, TMState> listOfStates = new HashMap<>();
    private HashSet<String> alphabet = new HashSet<>();
    private String currentState;
    private TMCell currentCell;
    private TMCell initialCell;
    private int currentCellNumber;
    private int numberOfCells;
    private boolean printDisabled = false;
    private int numberOfTransitions;
    private int lengthOfInput;
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public runtm(boolean p) {
        printDisabled = p;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error In Arguments, must be Turing Filename, and Input filename");
        }
        File f1 = new File(args[0]);
        File f2 = new File(args[1]);
        runtm t = new runtm(true);
        if (t.run(f1, f2)) System.out.println("ACCEPTING");
        else System.out.println("NOT ACCEPTING");
        System.out.println("Input size is " + t.lengthOfInput + " Number of Transitions " + t.numberOfTransitions);
        t.print();
    }

    public boolean run(File f1, File f2) {
        readTM(f1);
        putInput(f2);
        return performTransitions();
    }

    private boolean performTransitions() {
        while (true) {
            if (!printDisabled) print();
            TMState s = listOfStates.get(currentState);
            TMTransition t = s.getTransition(String.valueOf(currentCell.getValue()));
            if (!printDisabled) System.out.println("Current State " + currentState);
            if (t.getMoveDir() == null) {
                if (s.checkAcceptedState()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (!printDisabled) System.out.println("Next state " + currentState);
                move(t);
                numberOfTransitions++;
            }
        }
    }

    private void putInput(File f2) {
        String inputString;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f2));
            inputString = br.readLine();
            br.close();
            if (!printDisabled) System.out.println("Input " + inputString);
            numberOfCells = 0;
            numberOfTransitions = 0;
            lengthOfInput = inputString.length();
            for (int i = 0; i < inputString.length(); i++) {
                if (i == 0) {
                    initialCell = new TMCell(String.valueOf(inputString.charAt(i)));
                    currentCell = initialCell;
                } else {
                    TMCell c = new TMCell(String.valueOf(inputString.charAt(i)));
                    currentCell.next = c;
                    c.previous = currentCell;
                    currentCell = c;
                }
                numberOfCells++;
            }
            currentCell = initialCell;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTM(File f1) {
        String line;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f1));
//            Number of states
            line = br.readLine();
            String[] split = line.split(" ");
            if (!split[0].equals("states")) {
                System.out.println("Invalid usage ");
                System.exit(0);
            }
            int count = Integer.parseInt(split[1]);
//            Read in the number of states
            for (int numStates = 0; numStates < count; numStates++) {
                line = br.readLine();
                split = line.split(" ");

                boolean isTrue = false;
                if (split.length == 2) isTrue = true;

                TMState s;
                s = new TMState(isTrue);

                listOfStates.put(split[0], s);
                if (numStates == 0) currentState = split[0];
            }
//          Read the alphabet
            line = br.readLine();
            split = line.split(" ");
            count = Integer.parseInt(split[1]);
            for (int i = 0; i < count; i++) {
                alphabet.add(split[i + 2]);
            }


            while ((line = br.readLine()) != null) {
                split = line.split(" ");
                TMState t = listOfStates.get(split[0]);
                if (t != null) {
                    if (!alphabet.contains(split[1]) && !alphabet.contains(split[3]) && !split[1].equals("_")) {
                        System.out.println("Invalid Alphabet");
                        System.exit(0);
                    }
                    t.enterTransition(split);
                } else {
                    System.out.println("YO BRO Y U DO DIS");
                    System.exit(0);
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(TMTransition t) {
        currentCell.setValue(t.getOutput());
        switch (t.getMoveDir()) {
            case "L":
                moveLeft();
                break;
            case "R":
                moveRight();
                break;
            case "S":
                break;
            default:
                System.out.println("Bad Input");
                System.exit(0);
                break;
        }
        currentState = t.getNextState();
        return;
    }

    public void moveLeft() {
        if (currentCell.getPrevious() != null) {
            currentCell = currentCell.getPrevious();
            currentCellNumber--;
        } else {
            TMCell newCell = new TMCell();
            newCell.next = currentCell;
            currentCell.previous = newCell;
            currentCell = newCell;
            numberOfCells++;
        }
    }

    public void moveRight() {
        currentCellNumber++;
        if (currentCell.getNext() != null) {
            currentCell = currentCell.getNext();
        } else {
            TMCell newCell = new TMCell();
            newCell.previous = currentCell;
            currentCell.next = newCell;
            currentCell = newCell;
            numberOfCells++;
        }
    }

    public void print() {
        TMCell p = currentCell;
        int count = currentCellNumber;
        String[] s = new String[numberOfCells];
        while (p.previous != null) {
            p = p.previous;
            s[--count] = p.getValue();
        }

        s[currentCellNumber] = currentCell.getValue();
        count = currentCellNumber;
        p = currentCell;
        while (p.next != null) {
            p = p.next;
            s[++count] = p.getValue();
        }
        System.out.print("[");
        for (int i = 0; i < s.length; i++) {
            if (i == currentCellNumber) {
                System.out.print(ANSI_CYAN_BACKGROUND + ANSI_RED + s[i] + ANSI_RESET);
            } else {
                System.out.print(s[i]);
            }
            if (i != s.length - 1) System.out.print(", ");
        }
        System.out.print("]\n\n");
    }

    public int getNumberOfTransitions() {
        return numberOfTransitions;
    }

    public int getLengthOfInput(){
        return lengthOfInput;
    }
}
