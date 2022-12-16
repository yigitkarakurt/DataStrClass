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


        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insertDeneme(5);
        tree.insertDeneme(4);
        tree.insertDeneme(8);
        tree.insertDeneme(7);
        tree.insertDeneme(13);
        tree.insertDeneme(1);
        tree.inOrderDeneme();






    }
}
