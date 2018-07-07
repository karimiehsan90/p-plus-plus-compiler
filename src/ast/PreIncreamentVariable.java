package ast;

public class PreIncreamentVariable extends Variable {
    public PlusPlus plusPlus;
    public Variable variable;

    public PreIncreamentVariable(PlusPlus plusPlus, Variable variable) {
        this.plusPlus = plusPlus;
        this.variable = variable;
    }
}
