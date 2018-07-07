package ast;

public class ArrayIndex implements ASTNode {
    OpenBrace openBrace;
    Expr expr;
    CloseBrace closeBrace;

    public ArrayIndex(OpenBrace openBrace, Expr expr, CloseBrace closeBrace) {
        this.openBrace = openBrace;
        this.expr = expr;
        this.closeBrace = closeBrace;
    }
}
