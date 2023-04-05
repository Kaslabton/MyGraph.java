public class Edge extends GraphObject{
    public String name;
    private int weight;

    public Edge(String edgeName) {
        super();
    }

    public boolean equals(Edge other){
        return this.getName().equals(other.getName());
    }
}
