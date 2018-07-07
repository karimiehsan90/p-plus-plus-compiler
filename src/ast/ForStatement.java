package ast;

public class ForStatement extends LoopStatement {
    public For aFor;
    public OpenParen openParen;
    public Assignment assignment;
    public SemiColon semiColon;
    public Expr expr;
    public SemiColon semiColon1;
    public UpdateStatement updateStatement;
    public CloseParen closeParen;
    public Block block;

    public ForStatement(For aFor, OpenParen openParen, Assignment assignment, SemiColon semiColon, Expr expr, SemiColon semiColon1, UpdateStatement updateStatement, CloseParen closeParen, Block block) {
        this.aFor = aFor;
        this.openParen = openParen;
        this.assignment = assignment;
        this.semiColon = semiColon;
        this.expr = expr;
        this.semiColon1 = semiColon1;
        this.updateStatement = updateStatement;
        this.closeParen = closeParen;
        this.block = block;
    }
}
