package ast;

public class PostIncreamentVariable extends Variable {
    public Variable variable;
    public PlusPlus plusPlus;

    public PostIncreamentVariable(Variable variable, PlusPlus plusPlus) {
        this.variable = variable;
        this.plusPlus = plusPlus;
    }
}
