package ast;

public class IfStatement extends CondStatement {
    If anIf;
    OpenParen openParen;
    public Expr expr;
    CloseParen closeParen;
    public Block block;
    public ElseStatement elseStatement;

    public IfStatement(If anIf, OpenParen openParen, Expr expr, CloseParen closeParen, Block block) {
        this.anIf = anIf;
        this.openParen = openParen;
        this.expr = expr;
        this.closeParen = closeParen;
        this.block = block;
    }

    public IfStatement(If anIf, OpenParen openParen, Expr expr, CloseParen closeParen, Block block, ElseStatement elseStatement) {
        this.anIf = anIf;
        this.openParen = openParen;
        this.expr = expr;
        this.closeParen = closeParen;
        this.block = block;
        this.elseStatement = elseStatement;
    }
}
