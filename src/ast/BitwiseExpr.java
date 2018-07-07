package ast;

public class BitwiseExpr implements Expr {
    public Bitwise bitwise;
    public Expr expr;

    public BitwiseExpr(Bitwise bitwise, Expr expr) {
        this.bitwise = bitwise;
        this.expr = expr;
    }
}
