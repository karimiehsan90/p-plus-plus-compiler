package ast;

public class ElseStatement implements ASTNode {
    Else anElse;
    public Block block;

    public ElseStatement(Else anElse, Block block) {
        this.anElse = anElse;
        this.block = block;
    }
}
