public class TNode<T extends Comparable> implements Comparable {
    public T value;
    public TNode<T> left;
    public TNode<T> right;

    public String symbol;
    public double freq;
    public TNode(T val){
        value=val;
        left=right=null;
    }

    public TNode(String symbol, double freq){
        this.symbol = symbol;
        this.freq = freq;
        left=right=null;


    }
    public String toString(){
        return String.valueOf(value);
    }


    @Override
    public int compareTo(Object o) {
        String b = (String) o;

        if (((String) o).equalsIgnoreCase(b)){
            return 0;
        }else {
            return -1;
        }
    }
}