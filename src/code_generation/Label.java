package code_generation;

public class Label {
    private static int count = 0;
    public String name;
    public Label() {
        count++;
        name = "label" + count;
    }
    protected Label(String name){
        this.name = name;
    }
}
