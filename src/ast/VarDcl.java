package ast;

public class VarDcl implements BlockInner,ProgramInner {
    public ConstTer aConst;
    public Type type;
    public VarDclCnts varDclCnts;
    public SemiColon semiColon;

    public VarDcl(ConstTer aConst, Type type, VarDclCnts varDclCnts, SemiColon semiColon) {
        this.aConst = aConst;
        this.type = type;
        this.varDclCnts = varDclCnts;
        this.semiColon = semiColon;
    }

    public VarDcl(Type type, VarDclCnts varDclCnts, SemiColon semiColon) {
        this.type = type;
        this.varDclCnts = varDclCnts;
        this.semiColon = semiColon;
    }
}
