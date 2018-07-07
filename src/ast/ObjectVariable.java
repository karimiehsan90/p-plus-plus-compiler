package ast;

public class ObjectVariable extends Variable {
    public Variable variable;
    public Dot dot;
    public ID id;

    public ObjectVariable(Variable variable, Dot dot, ID id) {
        this.variable = variable;
        this.dot = dot;
        this.id = id;
    }
}
