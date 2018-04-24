import java.util.HashMap;

public class TMState{

	//hash map stores the input to that state and the corresponding transiton state 
	private HashMap <String, String > transitions = new HashMap<>();
	private boolean acceptedState;
	/**
	 * This initialises the state to match to a state in the automaton. 
	 * @param acceptedState whether this state accepts or not.
	 */
	public TMState(boolean acceptedState){
		this.acceptedState = acceptedState;
	}

	/**
	 * Checks whether this state is accepting or not.
	 * @return returns whether it is an accepted state or not 
	 */
	public boolean checkAcceptedState(){
		return this.acceptedState;
	}

	/**
	 * This takes one line of the input file and puts the input and the next state into the hash map. 
	 * adds a line to the transition table
	 */
	public void enterTransition(String[] inputs){
		String enteredInput = inputs[1];
		String nextState = inputs[2];
		//puts the input and the next state into the hash map
		transitions.put(enteredInput, nextState);
	}
	
	/**
	 * 
	 * @param userInput gets the character input from the user.
	 * @return this returns the state to go into next based on the input, null if there is no defined transition in the state the machine is in. 
	 */
	public String doTransition(String userInput){
		//if the map contains a transition for the input given it returns the state it needs to go to otherwise null
        return transitions.getOrDefault(userInput, null);
	}	
}