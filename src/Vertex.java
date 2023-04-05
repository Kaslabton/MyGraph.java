public class Vertex extends GraphObject {
    public Vertex(String name){
        super(name);
    }

    public boolean equals(Edge other){
        return this.getName().equals(other.getName());
    }
}
