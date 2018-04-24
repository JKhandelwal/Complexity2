import java.util.HashMap;

public class FSAutomaton {
	//Stores the state name and the object state 
	private HashMap<String, TMState> listOfStates= new HashMap<String,TMState>();
	private String currentState;
	private String initialState;
	private boolean initialStateSet = false;
	
	/**
	 * Initialises the hash map with a null state.
	 */
	public FSAutomaton() {
		listOfStates.put(null,new TMState(false));
	}
	
	/**
	 * This takes in one line of the description file, for the first line it sets the initial state. 
	 * if the state defined in the line does not exists, it is created and stored in the hash map
	 * then the transition is stored in the transition table for that state
	 * finally if the last state is accepting, it sets the state to be an accepting state
	 * @param inputs this is one line of the description file 
	 */
	public void getFileInput(String[] inputs){	
		//This sets the initial state once based on the first input to the description table. 
//		if (initialStateSet == false){
//			initialState = inputs[0];
//			initialStateSet = true;
//		}
//		//checks if the state already exists, if not creates it.
//		if (listOfStates.containsKey(inputs[0]) == false){
//			listOfStates.put(inputs[0],new TMState(inputs[0]));
//		}
//		//sends the transition details to the corresponding state
//			TMState temp = listOfStates.get(inputs[0]);
//			temp.putInput(inputs);
//		//checks if the end state is accepting in the line, if so creates the object if not already created
//		//Then calls a method to set that state as accepting.
//		if (inputs.length == 4){
//			if (listOfStates.containsKey(inputs[2]) == false){
//				listOfStates.put(inputs[2],new TMState(inputs[2]));
//			}
//			TMState temp1 = listOfStates.get(inputs[2]);
//			temp1.setAsAcceptedState();
//		}
	}
	/**
	 * This checks the user input and returns true or false depending upon if it leads to a valid state or not.
	 * @param input this is the string entered by the user
	 * @return true or false is returned if the end state is accepting or not. 
	 */
	public boolean checkUserInput(String input){		
		String strInput;
		boolean startInitialState = true;
		//loop through each character of the string 
		for(int i=0; i<input.length();i++){
			String temp;
			strInput = input.substring(i,i+1);
			//if this is the start of the string, start at the initial state.
			if (startInitialState == true){
				temp = listOfStates.get(initialState).doTransition(strInput);
				startInitialState = false;
			}else{
				temp = listOfStates.get(currentState).doTransition(strInput);
			}		
			//change the current state to what is returned from the transition.
			currentState = temp;
		}
		//after looping through the string, it checks whether the state it is in is accepting or not and return accordingly.  
		if (currentState == null){
			return false;
		}
		if (listOfStates.get(currentState).checkAcceptedState() == true){
			return true;	
		}
		return false;
	}			
}