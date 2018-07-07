package code_generation;

import java.io.PrintStream;

public class ReturnInstruction extends Instruction {
    public LLVM_Type type;
    public LLVM_Var var;

    public ReturnInstruction(LLVM_Type type, LLVM_Var var) {
        this.type = type;
        this.var = var;
    }

    public ReturnInstruction(LLVM_Type type) {
        this.type = type;
    }

    @Override
    public void createCode(PrintStream ps) {
        ps.print("ret " + type.name);
        if (var != null){
            ps.print(" " + var.getName());
        }
        ps.println();
    }
}
