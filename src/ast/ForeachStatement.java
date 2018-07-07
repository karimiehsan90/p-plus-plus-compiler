package ast;

public class ForeachStatement extends LoopStatement {
    Foreach foreach;
    OpenParen openParen;
    public ID id;
    In in;
    public ID id1;
    CloseParen closeParen;
    public Block block;

    public ForeachStatement(Foreach foreach, OpenParen openParen, ID id, In in, ID id1, CloseParen closeParen, Block block) {
        this.foreach = foreach;
        this.openParen = openParen;
        this.id = id;
        this.in = in;
        this.id1 = id1;
        this.closeParen = closeParen;
        this.block = block;
    }
}
