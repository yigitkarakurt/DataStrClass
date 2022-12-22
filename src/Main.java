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
        Graph<Integer> graph = new Graph<>();

        tree.insertDeneme(5);
        tree.insertDeneme(4);
        tree.insertDeneme(8);
        tree.insertDeneme(7);
        tree.insertDeneme(13);
        tree.insertDeneme(1);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1,3);
        graph.addEdge(1,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(2,3);
        graph.display();



    }


}
