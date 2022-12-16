public class Vertex <T extends Comparable>{

    T id;
    Vertex<T> next;
    Edge<T> edgeLink;

    public Vertex(T id){
        this.id = id;
        next = null;
        edgeLink = null;

    }




}
