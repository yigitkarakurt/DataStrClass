public class TNode<T extends Comparable> implements Comparable {
    T value;
    TNode<T> left;
    TNode<T> right;
    public TNode(T val){
        value=val;
        left=right=null;
    }
    public String toString(){
        return String.valueOf(value);
    }


    @Override
    public int compareTo(Object o) {
        int a = (int)this.value;
        int b = (int) o;

        if (a == b){
            return 0;
        }else if (a > b){
            return 1;
        }else {
            return -1;
        }
    }
}