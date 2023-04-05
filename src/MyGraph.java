import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class MyGraph {
    private int numVertices;
    private int numEdges;
    private HashMap<Vertex, ArrayList<GraphPairing>>graph;

    public MyGraph() {
        numVertices = 0;
        numEdges = 0;
        graph = new HashMap<>();
    }

    public int numVertices(){
        return numVertices;
    }

    public int numEdges(){
        return numEdges;
    }

    public void insertVertex(String name){
        Vertex temp = new Vertex(name);
        graph.put(temp,null);
        numVertices++;
    }


    public void print(){
        Set<Vertex> vertexList = graph.keySet();

        for(Vertex v1: vertexList){
            for(Vertex v2: vertexList) {
                if (v2.getName() != v1.getName()) {
                    if (getEdge(v1.getName(), v2.getName()) != null)
                        System.out.println(v1.getName()+"-->" + getEdge(v1.getName(), v2.getName()) + "-->" + v2.getName());
                }
            }
        }
    }

    public Set<Vertex> vertices(){
        return graph.keySet();
    }
    //This is 0(2n) can we make this 0(1)?

    public void insertEdge(String v1, String v2, String edgeName){
        Set<Vertex> vertices = graph.keySet();
        Vertex vertex1 = new Vertex(v1);
        Vertex vertex2  = new Vertex(v2);
        Edge edge = new Edge(edgeName);
        edge.setName(edgeName);

        //System.out.println(edge);

        for (Vertex v : vertices){
            if(v.compareTo(new Vertex(v1))==0){
                vertex1 = v;
                //System.out.println(vertex1.getName());
                //break;
            }
            if(v.compareTo(new Vertex(v2))==0){
                vertex2 = v;
                //System.out.println(vertex2.getName());
                break;
            }
        }
        //System.out.println("Contains v1: "+ graph.containsKey(vertex1));
        //System.out.println("Contains v2: "+ graph.containsKey(vertex2));

        ArrayList<GraphPairing> v1EdgeList = graph.get(vertex1);
        if(v1EdgeList==null){
            graph.put(vertex1, new ArrayList<>());
        }
        graph.get(vertex1).add(new GraphPairing(vertex1,edge));
        v1EdgeList = graph.get(vertex1);

        //System.out.println(v1EdgeList);


        ArrayList<GraphPairing> v2EdgeList = graph.get(vertex2);
        if(v2EdgeList==null){
            graph.put(vertex2, new ArrayList<>());
        }
        graph.get(vertex2).add(new GraphPairing(vertex2,edge));
        v2EdgeList = graph.get(vertex2);

        //System.out.println(v2EdgeList);

        /*ArrayList<String> edgevertices = new ArrayList<>();
        edgevertices.add(endVertices(edgeName)[0]);
        edgevertices.add(endVertices(edgeName)[1]);
        System.out.println("edge: "+ edgeName + " connected "+ edgevertices);*/

        numEdges++;
    }
    

    private Vertex getVertexFromString(String s){
        Set<Vertex> vertices = graph.keySet();
        for(Vertex v: vertices){
            if(v.getName().equals(s)){
                return v;
            }
        }
        return null;
    }

    public String getEdge(String vertex1, String vertex2){
        Vertex v1= getVertexFromString(vertex1);
        Vertex v2= getVertexFromString(vertex2);

        ArrayList<GraphPairing> gps1= graph.get(v1);
        ArrayList<GraphPairing> gps2= graph.get(v2);
        if(gps1 != null && gps2 != null) {
            for (GraphPairing gp1 : gps1) {
                for (GraphPairing gp2 : gps2)
                    if (gp1.getE() == gp2.getE()) {
                        return gp1.getE().getName();
                    }
            }
        }
        return null;
    }
    
    public String[] endVertices(String edge){
        String[] vertices = new String[2];
        Edge e = getEdgeFromString(edge);
        Vertex v1 = null;
        Vertex v2;
        Set<Vertex> vertexList = graph.keySet();
        for (Vertex vI: vertexList){
            ArrayList<GraphPairing> gps = graph.get(vI);
            for (GraphPairing gp:gps){
                if(gp.getE() == e){
                    v1 = vI;
                    vertices[0]=v1.getName();
                    //System.out.println("V1 is "+v1.getName());
                }
                break;
            }
            break;
        }
        for (Vertex vII: vertexList) {
            if (vII != v1) {
                ArrayList<GraphPairing> gps = graph.get(vII);
                for (GraphPairing gp : gps) {
                    if (gp.getE() == e && gp.getV() != v1) {
                        v2 = gp.getV();
                        vertices[1] = v2.getName();
                        //System.out.println("V2 is " + v2.getName());
                    }
                }
            }
        }
        return vertices;
    }

    private Edge getEdgeFromString(String s){
        Set<Vertex> vertices = graph.keySet();
        for(Vertex v: vertices){
            ArrayList<GraphPairing> gps= graph.get(v);
            if(gps != null)
                for (GraphPairing g:gps){
                    Edge e = g.getE();
                    if(e.getName().equals(s)){
                        return e;
                    }
                }
        }
        return null;
    }

    public String opposite(String vertex, String edge){
        Vertex v = getVertexFromString(vertex);
        Edge e = getEdgeFromString(edge);

        ArrayList<GraphPairing> gps = graph.get(v);
        if(gps==null)
            return null;
        return null;
    }
}
