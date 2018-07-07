package ast;

public class PreDecreamentVariable extends Variable {
    public MinusMinus minusMinus;
    public Variable variable;

    public PreDecreamentVariable(MinusMinus minusMinus, Variable variable) {
        this.minusMinus = minusMinus;
        this.variable = variable;
    }
}
