import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fsainterpreter { 
	private static FSAutomaton fsa = new FSAutomaton();

	/**
	 * This is the main method to start the automaton, takes in the file if valid and passes it to the readfile method 
	 * @param args the file name passed in 
	 */
	public static void main(String[] args){
		//if the user does not enter a file, the program does not proceed.
		if (args.length == 0){
			System.out.println("No description file Provided");
		}else{
			//Only if there has been a successful file read does the program go to taking user input. 
			if (readFile(args) == true){
				readInput();	
			}		
		}		
	}
	
/**
 * 
 * @param args gets the filename to read from 
 * @return returns whether it was a successful read and it should continue with the program or not
 */
	public static boolean readFile(String[] args){
		BufferedReader br = null;
			try {
				//sets the path of the file to be the entered file path 
				String Path = args[0];
				br = new BufferedReader(new FileReader(Path));
				String line;
				//while there is more text on the next line 
				while ((line = br.readLine()) != null) {
					//This skips empty lines
					if (line.length() == 0){
						
					}else{
						//splits the line by spaces
						String[] line2 = line.split("\\s+");
						//does input validation to ensure that the entered line in the file is in the correct format. 
						if (((line2.length < 3) || (line2.length > 4)) || (line2[1].length() != 1) || ((line2.length == 4) && (!line2[3].equals("*")))){
							System.out.println("Invalid string, line: "+ line + " in the file " + args[0] +" skipped, The line should have between 3 and 4 inputs");
						}else{
							//puts it in the Automaton
							fsa.getFileInput(line2);
						}						
					}
				}
				br.close();
				return true;
			} catch (IOException ioe) {
				//Prints errors if there are any. 
				System.err.println(ioe.getMessage());
				return false;
			}
		}
	
	/**
	 * This reads the user input from standard input while there is input and checks whether it is accepted or not. 
	 */
	public static void readInput(){
		BufferedReader br2 = null;        
        try {
			br2 = new BufferedReader(new InputStreamReader(System.in));
			String line1;
			while ((line1 = br2.readLine()) != null) {
				//sends the input line by line to be checked
				//prints accepted or not accepted depending on the result
				if (fsa.checkUserInput(line1) == false){
					System.out.println("Not accepted");
				}else{
					System.out.println("Accepted");
				}
			}
			br2.close();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
}
	
	
	
	
	
