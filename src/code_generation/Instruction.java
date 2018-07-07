package code_generation;

import java.io.PrintStream;

public abstract class Instruction {
    public abstract void createCode(PrintStream ps);

}
