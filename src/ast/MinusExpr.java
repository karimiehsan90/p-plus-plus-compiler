package ast;

public class MinusExpr implements Expr {
    public Minus minus;
    public Expr expr;

    public MinusExpr(Minus minus, Expr expr) {
        this.minus = minus;
        this.expr = expr;
    }
}
