public class Main {
    public static void main(String[] args) {
        MyGraph g = new MyGraph();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");
        g.insertVertex("F");
        g.insertVertex("G");
        g.insertVertex("H");
        g.insertVertex("I");
        g.insertVertex("J");
        g.insertVertex("K");
        g.insertVertex("L");
        g.insertVertex("M");
        g.insertVertex("N");
        g.insertVertex("O");
        g.insertVertex("P");

        g.insertEdge("A","B","1");
        g.insertEdge("C","D","2");
        g.insertEdge("E","F","7");
        g.insertEdge("A","F","3");
        g.insertEdge("G","H","8");
        g.insertEdge("D","G","5");
        g.insertEdge("D","G","6");
        g.insertEdge("B","G","4");
        g.insertEdge("I","E","9");
        g.insertEdge("I","J","14");
        g.insertEdge("J","E","10");
        g.insertEdge("J","G","11");
        g.insertEdge("K","G","12");
        g.insertEdge("K","L","15");
        g.insertEdge("L","H","13");
        g.insertEdge("M","I","16");
        g.insertEdge("M","N","20");
        g.insertEdge("N","J","17");
        g.insertEdge("O","P","21");
        g.insertEdge("P","K","18");
        g.insertEdge("P","L","19");


        g.print();
        System.out.println("");
        System.out.println("Num Vertices: " + g.numVertices());
        System.out.println("Num Edges: " + g.numEdges());
    }
}