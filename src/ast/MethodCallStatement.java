package ast;

public class MethodCallStatement implements Statement {
    public MethodCall methodCall;
    public SemiColon semiColon;

    public MethodCallStatement(MethodCall methodCall, SemiColon semiColon) {
        this.methodCall = methodCall;
        this.semiColon = semiColon;
    }
}
