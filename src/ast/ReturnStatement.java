package ast;

public class ReturnStatement implements Statement {
    Return aReturn;
    public Expr expr;
    SemiColon semiColon;

    public ReturnStatement(Return aReturn, Expr expr, SemiColon semiColon) {
        this.aReturn = aReturn;
        this.expr = expr;
        this.semiColon = semiColon;
    }

    public ReturnStatement(Return aReturn, SemiColon semiColon) {
        this.aReturn = aReturn;
        this.semiColon = semiColon;
    }
}
