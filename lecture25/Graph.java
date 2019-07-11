package lecture25;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by piyush0 on 28/07/17.
 */
public class Graph {

    private class Edge {
        Vertex one;
        Vertex two;

        public Edge(Vertex one, Vertex two) {
            this.one = one;
            this.two = two;
        }
    }

    private class Vertex {
        String name;
        HashMap<Vertex, Edge> nbrs;

        public Vertex(String name) {
            this.name = name;
            this.nbrs = new HashMap<>();
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            Vertex o = (Vertex) other;
            return this.name.equals(o.name);
        }

        public boolean isAdjacentTo(Vertex other) {
            return this.nbrs.containsKey(other);
        }
    }

    private HashMap<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void display() {
        Collection<Vertex> vertices = this.vertices.values();

        for (Vertex vtx : vertices) {
            System.out.print(vtx.name + " => ");

            Set<Vertex> nbrsOfVtx = vtx.nbrs.keySet();

            for (Vertex nbr : nbrsOfVtx) {
                System.out.print(nbr.name + ", ");
            }

            System.out.println("END");
        }
    }

    public void addVertex(String v) throws Exception {

        if (this.vertices.containsKey(v)) {
            throw new Exception("Vertex already contained");
        }

        Vertex vtx = new Vertex(v);
        this.vertices.put(v, vtx);
    }

    public int numVertices() {
        return this.vertices.size();
    }

    public void removeVertex(String v) throws Exception {
        if (!this.vertices.containsKey(v)) {
            throw new Exception("Vertex not contained");
        }

        Vertex toBeRemoved = this.vertices.get(v);

        Set<Vertex> nbrs = toBeRemoved.nbrs.keySet();

        for (Vertex nbr : nbrs) {
            nbr.nbrs.remove(toBeRemoved);
        }

        this.vertices.remove(v);

    }

    public int numEdges() {
        int rv = 0;


        Collection<Vertex> vertices = this.vertices.values();

        for (Vertex vtx : vertices) {
            rv += vtx.nbrs.size();
        }

        return rv / 2;

    }

    public void addEdge(String v1, String v2) throws Exception {
        Vertex vtx1 = this.vertices.get(v1);
        Vertex vtx2 = this.vertices.get(v2);

        if (vtx1 == null || vtx2 == null) {
            throw new Exception("The vertices does not exist");
        }

        if (containsEdge(v1, v2)) {
            throw new Exception("Edge already exists");
        }

        Edge edge = new Edge(vtx1, vtx2);
        vtx1.nbrs.put(vtx2, edge);
        vtx2.nbrs.put(vtx1, edge);
    }

    public void removeEdge(String v1, String v2) throws Exception {
        Vertex vtx1 = this.vertices.get(v1);
        Vertex vtx2 = this.vertices.get(v2);

        if (vtx1 == null || vtx2 == null) {
            throw new Exception("The vertices does not exist");
        }

        if (!containsEdge(v1, v2)) {
            throw new Exception("Edge does not exist");
        }

        vtx1.nbrs.remove(vtx2);
        vtx2.nbrs.remove(vtx1);

    }

    public boolean containsEdge(String v1, String v2) throws Exception {
        Vertex vtx1 = this.vertices.get(v1);
        Vertex vtx2 = this.vertices.get(v2);

        if (vtx1 == null || vtx2 == null) {
            throw new Exception("The vertices does not exist");
        }

        return vtx1.isAdjacentTo(vtx2);
    }


    /* QUESTIONS */


    public boolean hasPathFromTo(String v1, String v2) throws Exception {
        Vertex vtx1 = this.vertices.get(v1);
        Vertex vtx2 = this.vertices.get(v2);

        if (vtx1 == null || vtx2 == null) {
            throw new Exception("The vertices does not exist");
        }
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        visited.put(vtx1, true);
        return hasPathFromTo(vtx1, vtx2, visited);
    }

    private boolean hasPathFromTo(Vertex vtx1, Vertex vtx2,
                                  HashMap<Vertex, Boolean> visited) {
        if (vtx1.isAdjacentTo(vtx2)) {
            return true;
        }

        Set<Vertex> nbrs = vtx1.nbrs.keySet();

        for (Vertex nbr : nbrs) {

            if (!visited.containsKey(nbr)) {

                visited.put(nbr, true);
                if (hasPathFromTo(nbr, vtx2, visited)) {
                    return true;
                }
            }


        }

        return false;
    }

    public boolean hasPathFromToBFS(String v1, String v2) throws Exception {
        Vertex vtx1 = this.vertices.get(v1);
        Vertex vtx2 = this.vertices.get(v2);

        if (vtx1 == null || vtx2 == null) {
            throw new Exception("The vertices does not exist");
        }

        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.put(vtx1, true);
        queue.offer(vtx1);

        while (!queue.isEmpty()) {
            Vertex vtx = queue.poll();

            // work
            if (vtx.isAdjacentTo(vtx2)) {
                return true;
            }

            Set<Vertex> nbrs = vtx.nbrs.keySet();

            for (Vertex nbr : nbrs) {

                if (!visited.containsKey(nbr)) {
                    visited.put(nbr, true);
                    queue.offer(nbr);
                }
            }
        }


        return false;
    }

    public boolean hasPathFromToDFSI(String v1, String v2) throws Exception {
        Vertex vtx1 = this.vertices.get(v1);
        Vertex vtx2 = this.vertices.get(v2);

        if (vtx1 == null || vtx2 == null) {
            throw new Exception("The vertices does not exist");
        }

        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Stack<Vertex> stack = new Stack<>();

        visited.put(vtx1, true);
        stack.push(vtx1);

        while (!stack.isEmpty()) {
            Vertex vtx = stack.pop();

            // work
            if (vtx.isAdjacentTo(vtx2)) {
                return true;
            }

            Set<Vertex> nbrs = vtx.nbrs.keySet();

            for (Vertex nbr : nbrs) {

                if (!visited.containsKey(nbr)) {
                    visited.put(nbr, true);
                    stack.push(nbr);
                }
            }
        }


        return false;
    }

    public void bft() {

        Collection<Vertex> vertices = this.vertices.values();


        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex vtx : vertices) {

            if (!visited.containsKey(vtx)) {

                visited.put(vtx, true);
                queue.offer(vtx);

                while (!queue.isEmpty()) {

                    Vertex vertex = queue.poll();

                    // work
                    System.out.print(vertex.name + " ");


                    Set<Vertex> nbrsOfVertex = vertex.nbrs.keySet();

                    for (Vertex nbr : nbrsOfVertex) {
                        if (!visited.containsKey(nbr)) {
                            visited.put(nbr, true);
                            queue.offer(nbr);
                        }
                    }

                }


            }
        }
        System.out.println("END");
    }

    public void dft() {

        Collection<Vertex> vertices = this.vertices.values();


        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Stack<Vertex> stack = new Stack<>();

        for (Vertex vtx : vertices) {

            if (!visited.containsKey(vtx)) {

                visited.put(vtx, true);
                stack.push(vtx);

                while (!stack.isEmpty()) {

                    Vertex vertex = stack.pop();

                    // work
                    System.out.print(vertex.name + " ");


                    Set<Vertex> nbrsOfVertex = vertex.nbrs.keySet();

                    for (Vertex nbr : nbrsOfVertex) {
                        if (!visited.containsKey(nbr)) {
                            visited.put(nbr, true);
                            stack.push(nbr);
                        }
                    }

                }


            }
        }
        System.out.println("END");
    }

    public boolean isConnected() {
        Collection<Vertex> vertices = this.vertices.values();

        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex vtx : vertices) {

            if (!visited.containsKey(vtx)) {

                visited.put(vtx, true);
                queue.offer(vtx);

                while (!queue.isEmpty()) {

                    Vertex vertex = queue.poll();

                    // work

                    Set<Vertex> nbrsOfVertex = vertex.nbrs.keySet();

                    for (Vertex nbr : nbrsOfVertex) {
                        if (!visited.containsKey(nbr)) {
                            visited.put(nbr, true);
                            queue.offer(nbr);
                        }
                    }

                }

                return this.numVertices() == visited.size();
            }
        }

        return true;
    }

    public ArrayList<ArrayList<String>> gcc() {

        ArrayList<ArrayList<String>> rv = new ArrayList<>();

        Collection<Vertex> vertices = this.vertices.values();

        HashMap<Vertex, Boolean> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex vtx : vertices) {

            if (!visited.containsKey(vtx)) {

                ArrayList<String> curr = new ArrayList<>();

                visited.put(vtx, true);
                queue.offer(vtx);

                while (!queue.isEmpty()) {

                    Vertex vertex = queue.poll();

                    // work
                    curr.add(vertex.name);

                    Set<Vertex> nbrsOfVertex = vertex.nbrs.keySet();

                    for (Vertex nbr : nbrsOfVertex) {
                        if (!visited.containsKey(nbr)) {
                            visited.put(nbr, true);
                            queue.offer(nbr);
                        }
                    }

                }

                rv.add(curr);


            }
        }


        return rv;
    }

    public boolean isBipartite() {
        Collection<Vertex> vertices = this.vertices.values();

        HashMap<Vertex, String> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex vtx : vertices) {

            if (!visited.containsKey(vtx)) {

                visited.put(vtx, "R");
                queue.offer(vtx);

                while (!queue.isEmpty()) {

                    Vertex vertex = queue.poll();

                    // work

                    String colorOnVertex = visited.get(vertex);

                    String colorToApply = "";

                    if (colorOnVertex.equals("R")) {
                        colorToApply = "G";
                    } else {
                        colorToApply = "R";
                    }

                    Set<Vertex> nbrsOfVertex = vertex.nbrs.keySet();

                    for (Vertex nbr : nbrsOfVertex) {
                        if (!visited.containsKey(nbr)) {
                            visited.put(nbr, colorToApply);
                            queue.offer(nbr);
                        } else {
                            String colorAlreadyPresent = visited.get(nbr);

                            if (!colorAlreadyPresent.equals(colorToApply)) {
                                return false;
                            }
                        }
                    }

                }


            }
        }

        return true;

    }

    public boolean isAcyclic() {

        Collection<Vertex> vertices = this.vertices.values();

        HashMap<Vertex, Vertex> visited = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex vtx : vertices) {

            if (!visited.containsKey(vtx)) {

                visited.put(vtx, null);
                queue.offer(vtx);

                while (!queue.isEmpty()) {

                    Vertex vertex = queue.poll();

                    // work


                    Set<Vertex> nbrsOfVertex = vertex.nbrs.keySet();

                    for (Vertex nbr : nbrsOfVertex) {
                        if (!visited.containsKey(nbr)) {
                            visited.put(nbr, vertex);
                            queue.offer(nbr);
                        } else {
                            Vertex reasonForVertex = visited.get(vertex);

                            if (reasonForVertex != nbr) {
                                return false;
                            }
                        }
                    }

                }

            }


        }

        return true;
    }
}