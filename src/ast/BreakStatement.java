package ast;

public class BreakStatement implements Statement {
    Break aBreak;
    SemiColon semiColon;

    public BreakStatement(Break aBreak, SemiColon semiColon) {
        this.aBreak = aBreak;
        this.semiColon = semiColon;
    }
}
