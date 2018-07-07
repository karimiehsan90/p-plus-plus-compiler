package code_generation;

import java.io.PrintStream;

public class BlankInstruction extends Instruction {
    public Label label;

    public BlankInstruction(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label.name;
    }

    @Override
    public void createCode(PrintStream ps) {
        ps.println(label.name + ":");
    }
}
