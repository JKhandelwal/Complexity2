public class TMTransition {
    private String nextState;
    private String output;
    private String moveDir;

    public TMTransition( String nextState, String output, String moveDir) {
        this.nextState = nextState;
        this.output = output;
        this.moveDir = moveDir;
    }

    public String getNextState() {
        return nextState;
    }

    public String getOutput() {
        return output;
    }

    public String getMoveDir() {
        return moveDir;
    }
}
