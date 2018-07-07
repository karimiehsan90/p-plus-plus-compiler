package ast;

public class BinaryExpr implements Expr {
    public Expr expr1;
    public BinaryOperator op;
    public Expr expr2;

    public BinaryExpr(Expr expr1, BinaryOperator op, Expr expr2) {
        this.expr1 = expr1;
        this.op = op;
        this.expr2 = expr2;
    }
}
