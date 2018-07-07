package ast;

public class Argument implements ASTNode {
    public Type type;
    public ID id;
    public ArrayIndexList braces;

    public Argument(Type type, ID id, ArrayIndexList braces) {
        this.type = type;
        this.id = id;
        this.braces = braces;
    }
}
