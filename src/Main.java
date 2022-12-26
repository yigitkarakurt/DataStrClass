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


        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addEndVize2(2);
        linkedList.addEndVize2(15);
        linkedList.addEndVize2(6);
        linkedList.addEndVize2(4);
        linkedList.addEndVize2(1);
        linkedList.addEndVize2(66);

        linkedList.selectionSort();
        linkedList.display();


        /*
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Graph<Integer> graph = new Graph<>();

        tree.insert(5);
        tree.insert(4);
        tree.insert(8);
        tree.insert(7);
        tree.insert(13);
        tree.insert(1);

        System.out.println(tree.findMin());

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
        //graph.display();

         */



    }


}
