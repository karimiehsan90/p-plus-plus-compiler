package ast;

public class FunctionDec extends FunctionExtern {
    public Function function;
    public Type type;
    public ID id;
    public OpenParen openParen;
    public Arguments arguments;
    public CloseParen closeParen;
    public SemiColon semiColon;
    public Block block;

    public FunctionDec(Function function, Type type, ID id, OpenParen openParen, Arguments arguments, CloseParen closeParen, SemiColon semiColon) {
        this.function = function;
        this.type = type;
        this.id = id;
        this.openParen = openParen;
        this.arguments = arguments;
        this.closeParen = closeParen;
        this.semiColon = semiColon;
    }

    public FunctionDec(Function function, Type type, ID id, OpenParen openParen, Arguments arguments, CloseParen closeParen, Block block) {
        this.function = function;
        this.type = type;
        this.id = id;
        this.openParen = openParen;
        this.arguments = arguments;
        this.closeParen = closeParen;
        this.block = block;
    }
}
