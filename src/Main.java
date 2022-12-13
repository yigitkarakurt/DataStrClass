import java.io.IOException;


public class Main {

    public static void addElements(Stack stk){
        int size = stk.size();
        Stack temp = new Stack(size);
        int total = 0;


        for (int i = 0; i < size; i++) {
            total += stk.peek();
            temp.push(stk.pop());

        }
        for (int i = 0; i < size; i++) {
            stk.push(temp.pop());

        }
        System.out.println(total);

    }

    public static void main(String[] args) throws IOException {

        LinkedList<Integer> list = new LinkedList<>();

        list.huffmanHW();




    }
}
