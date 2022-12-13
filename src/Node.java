public class Node<T extends Comparable> implements Comparable {
    public T value;
    public int freq;
    public char ch;

    public Node<T> next;

    public Node(T val) {
        this.value = val;
        this.next = null;
    }

    public Node(int freq, char ch){
        this.freq = freq;
        this.ch = ch;
        this.next = null;
    }


    public String toString() {
        return String.valueOf(this.value);
    }


    @Override
    public int compareTo(Object o) {
        Node a = (Node) o;

        if (this.freq == a.freq){
            return 0;
        }else if(this.freq > a.freq){
            return 1;
        }else{
            return -1;
        }



    }
}
