public class Graph <T extends Comparable>{

    Vertex<T> head;

    public void addVertex(T id){

        Vertex<T> newVertex = new Vertex<>(id);

        if (head == null){
            head = newVertex;
        }else{
            Vertex<T> iterator = head;
            while(iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = newVertex;
        }
    }

    public void addEdge(T startId, T endId){
        Vertex<T> current = findVertex(startId);

        if (current == null){
            System.out.println("non found");
        }else{
            Edge<T> iterator = current.edgeLink;
            if(iterator == null){
                current.edgeLink = new Edge(endId);
            }else{
                while (iterator.next != null)
                    iterator = iterator.next;
                iterator.next = new Edge(endId);
            }
        }


    }

    public Vertex<T> findVertex(T id){
        Vertex<T> iterator = head;

        while(iterator != null){
            if(iterator.id == id){
                return iterator;
            }
            iterator = iterator.next;
        }
        return null;
    }

    public void display(){

        Vertex<T> iterator = head;

        while(iterator != null){
            System.out.print(iterator.id + "--->");
            Edge<T> iteratorEdge = iterator.edgeLink;

            while (iteratorEdge != null){
                System.out.print(iteratorEdge.vertexId + " ");
                iteratorEdge = iteratorEdge.next;
            }
            System.out.println();
            iterator = iterator.next;
        }



    }
}
