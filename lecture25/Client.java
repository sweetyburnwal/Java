package lecture25;

/**
 * Created by piyush0 on 28/07/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Graph g = new Graph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "D");
        g.addEdge("D", "E");
        g.addEdge("E", "F");
        g.addEdge("G", "E");
        g.addEdge("G", "F");


        g.display();

//        g.removeEdge("F", "G");


        System.out.println(g.isAcyclic());
    }
}
