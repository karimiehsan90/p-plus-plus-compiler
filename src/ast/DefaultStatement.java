package ast;

public class DefaultStatement implements ASTNode {
    Default aDefault;
    Colon colon;
    public Block block;

    public DefaultStatement(Default aDefault, Colon colon, Block block) {
        this.aDefault = aDefault;
        this.colon = colon;
        this.block = block;
    }
}
