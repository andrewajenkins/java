package algo.objects;

public class Vertex {
    public int data;
    public int c; //color
    public int d; //distance
    public int t; //time
    public Vertex p; //predecessor

    @Override
    public String toString() {
        return "data: " + data + "color: " + c + " distance: "
                + d + " predecessor: " + p.data;
    }
}
