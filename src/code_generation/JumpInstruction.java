package code_generation;

import java.io.PrintStream;

public class JumpInstruction extends Instruction {
    public Label goal;

    public JumpInstruction(Label goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return Opcode.JP + " " + goal.name;
    }

    @Override
    public void createCode(PrintStream ps) {
        ps.println("br label %" + goal.name);
    }
}
