package ast;

public class SizeofExpr implements Expr {
    Sizeof sizeof;
    OpenParen openParen;
    public Type type;
    CloseParen closeParen;

    public SizeofExpr(Sizeof sizeof, OpenParen openParen, Type type, CloseParen closeParen) {
        this.sizeof = sizeof;
        this.openParen = openParen;
        this.type = type;
        this.closeParen = closeParen;
    }
}
