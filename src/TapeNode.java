public class TapeNode {

    public TapeNode next;
    public TapeNode previous;
    public String value;


    public TapeNode(String value) {
        this.next = null;
        this.previous = null;
        this.value = value;
    }

    public void setNext(TapeNode n){
        this.next = n;
    }

    public void setPrevious(TapeNode p){
        this.previous = p;
    }
}
