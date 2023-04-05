public class GraphObject implements Comparable<Vertex>{
    public String name;
    private int weight;

    public GraphObject(String name) {
        this.name = name;
    }

    public GraphObject() {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GraphObject{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        return name.compareTo(o.name);
    }
}