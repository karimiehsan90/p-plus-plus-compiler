package ast;

public class PostDecreamentVariable extends Variable {
    public Variable variable;
    public MinusMinus minusMinus;

    public PostDecreamentVariable(Variable variable, MinusMinus minusMinus) {
        this.variable = variable;
        this.minusMinus = minusMinus;
    }
}
