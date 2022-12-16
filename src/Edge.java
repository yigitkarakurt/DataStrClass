public class Edge<T extends Comparable> {

    T vertexId;
    Edge<T> next;

    public Edge(T id){
        vertexId = id;
        next = null;

    }

}
