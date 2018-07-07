package ast;

public class Program implements ASTNode{
    public ProgramInnerList programInners;

    public Program() {
        programInners = new ProgramInnerList();
    }
}
