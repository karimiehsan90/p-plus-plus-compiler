package ast;

public class ExternDec extends FunctionExtern {
    Extern extern;
    Type type;
    ID id;
    SemiColon semiColon;

    public ExternDec(Extern extern, Type type, ID id, SemiColon semiColon) {
        this.extern = extern;
        this.type = type;
        this.id = id;
        this.semiColon = semiColon;
    }
}
