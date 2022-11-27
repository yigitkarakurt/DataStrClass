public class TNode<T extends Comparable> {
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
}