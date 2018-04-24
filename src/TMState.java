import java.util.HashMap;

public class TMState{

	//hash map stores the input to that state and the corresponding transiton state 
	private HashMap <String, TMTransition > transitions = new HashMap<>();
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
		//puts the input and the next state into the hash map
		transitions.put(inputs[1], new TMTransition(inputs[2],inputs[3],inputs[4]));
	}
	
	/**
	 * 
	 * @param userInput gets the character input from the user.
	 * @return this returns the state to go into next based on the input, null if there is no defined transition in the state the machine is in. 
	 */
	public TMTransition getTransition(String userInput){
        return transitions.getOrDefault(userInput, new TMTransition(null,null,null));
	}	
}