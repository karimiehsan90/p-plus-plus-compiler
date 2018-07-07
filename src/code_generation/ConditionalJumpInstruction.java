package code_generation;

import java.io.PrintStream;

public class ConditionalJumpInstruction extends Instruction {
    public Opcode opcode = Opcode.EQ;
    public LLVM_Var var;
    public Label goal;
    public Label wrongGoal;

    public ConditionalJumpInstruction(LLVM_Var var, Label goal, Label wrongGoal) {
        this.var = var;
        this.goal = goal;
        this.wrongGoal = wrongGoal;
    }

    @Override
    public String toString() {
        return opcode + " " + var.name + " " + goal.name + " " + wrongGoal.name;
    }

    @Override
    public void createCode(PrintStream ps) {
        ps.println("br i1 " + var.getName() + ", label %" + goal.name + ", label %" + wrongGoal.name);
    }
}
