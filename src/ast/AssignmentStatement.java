package ast;

public class AssignmentStatement implements Statement {
    public Assignment assignment;
    SemiColon semiColon;

    public AssignmentStatement(Assignment assignment, SemiColon semiColon) {
        this.assignment = assignment;
        this.semiColon = semiColon;
    }
}
