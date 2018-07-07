package ast;

public class VarDclCnt implements ASTNode {
    public Variable variable;
    public Assign assign;
    public Expr expr;

    public VarDclCnt(Variable variable) {
        this.variable = variable;
    }

    public VarDclCnt(Variable variable, Assign assign, Expr expr) {
        this.variable = variable;
        this.assign = assign;
        this.expr = expr;
    }
}
