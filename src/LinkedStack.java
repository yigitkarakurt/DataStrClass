public class LinkedStack <T extends Comparable>{

    Node<T> top;

    public boolean isEmpty(){
        return this.top == null;
    }

    public int count(){
        Node<T> iterator = top;
        int count = 0;
        while(iterator != null){
            iterator = iterator.next;
            count++;
        }
        return count;
    }

    public void push(T val){
        Node<T> newNode = new Node<T>(val);
        if (top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }

    }

    public T pop(){
        if (isEmpty()){
            return null;
        }else{
            T popped = top.value;
            top = top.next;
            return popped;
        }
    }

    public void display(){
        Node<T> iterator = top;
        while(iterator != null){
            System.out.println(iterator);
            iterator = iterator.next;
        }

    }

    public T peek(){

        if (isEmpty()){
            return null;
        }else {
            T topVal = top.value;
            return topVal;
        }
    }

}
