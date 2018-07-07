package ast;

public class MethodCall implements Expr {
    public ID id;
    OpenParen openParen;
    public Parameters parameters;
    CloseParen closeParen;

    public MethodCall(ID id, OpenParen openParen, Parameters parameters, CloseParen closeParen) {
        this.id = id;
        this.openParen = openParen;
        this.parameters = parameters;
        this.closeParen = closeParen;
    }
}
