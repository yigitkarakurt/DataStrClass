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

        /*
        Stack stk = new Stack(5);

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        int a = stk.count();


        System.out.println(a);
        stk.display();
                 */
        LinkedList<Integer> list = new LinkedList<>();


        list.addHead2(6);
        list.addHead2(5);
        list.addHead2(4);
        list.delete(4);
        list.display();




    }
}
