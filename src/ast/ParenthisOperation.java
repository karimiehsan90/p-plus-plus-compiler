package ast;

public class ParenthisOperation implements Expr {
    OpenParen openParen;
    public Expr expr;
    CloseParen closeParen;

    public ParenthisOperation(OpenParen openParen, Expr expr, CloseParen closeParen) {
        this.openParen = openParen;
        this.expr = expr;
        this.closeParen = closeParen;
    }
}
