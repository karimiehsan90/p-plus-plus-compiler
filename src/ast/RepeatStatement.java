package ast;

public class RepeatStatement extends LoopStatement {
    Repeat repeat;
    public Block block;
    Until until;
    OpenParen openParen;
    public Expr expr;
    CloseParen closeParen;
    SemiColon semiColon;

    public RepeatStatement(Repeat repeat, Block block, Until until, OpenParen openParen, Expr expr, CloseParen closeParen, SemiColon semiColon) {
        this.repeat = repeat;
        this.block = block;
        this.until = until;
        this.openParen = openParen;
        this.expr = expr;
        this.closeParen = closeParen;
        this.semiColon = semiColon;
    }
}
