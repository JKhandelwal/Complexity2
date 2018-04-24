public class TMCell {

    public TMCell next;
    public TMCell previous;
    public String value;


    public TMCell(String value) {
        this.next = null;
        this.previous = null;
        this.value = value;
    }

    public TMCell getNext() {
        return next;
    }

    public TMCell getPrevious() {
        return previous;
    }

    public String getValue() {
        return value;
    }

    public TMCell() {
        this.next = null;
        this.previous = null;
        this.value = "_";
    }

    public void setNext(TMCell n){
        this.next = n;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPrevious(TMCell p){
        this.previous = p;
    }
}
