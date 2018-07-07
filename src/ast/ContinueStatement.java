package ast;

public class ContinueStatement implements Statement {
    Continue aContinue;
    SemiColon semiColon;

    public ContinueStatement(Continue aContinue, SemiColon semiColon) {
        this.aContinue = aContinue;
        this.semiColon = semiColon;
    }
}
