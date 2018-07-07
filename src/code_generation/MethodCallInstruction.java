package code_generation;

import java.io.PrintStream;
import java.util.List;

public class MethodCallInstruction extends Instruction {
    public LLVM_Type returnType;
    public List<LLVM_Var> vars;
    public String name;
    public LLVM_Var out;

    public MethodCallInstruction(LLVM_Type returnType, List<LLVM_Var> vars, String name, LLVM_Var out) {
        this.returnType = returnType;
        this.vars = vars;
        this.name = name;
        this.out = out;
    }

    @Override
    public void createCode(PrintStream ps) {
        ps.print(out.getName() + " = call " + returnType.name + " @" + name + "(");
        boolean isFirst = false;
        for (LLVM_Var var:vars) {
            if (isFirst){
                ps.print(",");
            }
            ps.print(var.type.name + " " + var.getName());
            isFirst = true;
        }
        ps.println(")");
    }
}
