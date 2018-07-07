package ast;

public class SwitchStatement extends CondStatement {
    Switch aSwitch;
    OpenParen openParen;
    public ID id;
    CloseParen closeParen;
    Of of;
    Colon colon;
    Begin begin;
    public CaseList caseList;
    public DefaultStatement defaultStatement;
    End end;

    public SwitchStatement(Switch aSwitch, OpenParen openParen, ID id, CloseParen closeParen, Of of, Colon colon, Begin begin, CaseList caseList, DefaultStatement defaultStatement, End end) {
        this.aSwitch = aSwitch;
        this.openParen = openParen;
        this.id = id;
        this.closeParen = closeParen;
        this.of = of;
        this.colon = colon;
        this.begin = begin;
        this.caseList = caseList;
        this.defaultStatement = defaultStatement;
        this.end = end;
    }
}
