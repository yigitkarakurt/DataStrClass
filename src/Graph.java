public class Graph <T extends Comparable>{

    Vertex<T> head;

    public void addVertex(T id){

        Vertex<T> newVertex = new Vertex<>(id);

        if (head == null){
            head = newVertex;
        }else{
            Vertex<T> iterator = head;
            while(iterator != null){

                

                iterator = iterator.next;
            }



        }


    }
}
