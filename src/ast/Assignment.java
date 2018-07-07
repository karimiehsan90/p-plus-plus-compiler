package ast;

public class Assignment implements UpdateStatement {
    public Variable variable;
    public AssignOpr assignOpr;
    public Expr expr;

    public Assignment(Variable variable, AssignOpr assignOpr, Expr expr) {
        this.variable = variable;
        this.assignOpr = assignOpr;
        this.expr = expr;
    }
}
