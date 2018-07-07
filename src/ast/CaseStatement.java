package ast;

public class CaseStatement implements ASTNode,Comparable<CaseStatement> {
    Case aCase;
    public IntConst ic;
    Colon colon;
    public Block block;

    public CaseStatement(Case aCase, IntConst ic, Colon colon, Block block) {
        this.aCase = aCase;
        this.ic = ic;
        this.colon = colon;
        this.block = block;
    }

    @Override
    public int compareTo(CaseStatement o) {
        return Integer.valueOf((String) this.ic.symbol.value).compareTo(Integer.valueOf((String) o.ic.symbol.value));
    }
}
