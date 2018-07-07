package code_generation;

import java.io.PrintStream;

public class BasicInstruction extends Instruction {
    public Opcode op;
    public LLVM_Var var1;
    public LLVM_Var var2;
    public LLVM_Var out;
    public String type;
    public Label label;

    public BasicInstruction(Opcode op, LLVM_Var var1, LLVM_Var var2, LLVM_Var out, LLVM_Type type, Label label) {
        this.op = op;
        this.var1 = var1;
        this.var2 = var2;
        this.out = out;
        this.type = type.name;
        this.label = label;
    }

    @Override
    public String toString() {
        String s = "";
        if (label != null){
            s += label.name + " : ";
        }
        s += op + " ";
        if (var1 != null){
            s += var1.toString() + " ";
        }
        if (var2 != null){
            s += var2.toString() + " ";
        }
        if (out != null){
            s += out.toString() + " ";
        }
        return s;
    }

    @Override
    public void createCode(PrintStream ps) {
        switch (op){
            case ADD:
                ps.println(out.getName() + "="  + "add " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case SUB:
                ps.println(out.getName() + "="  + "sub " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case MUL:
                ps.println(out.getName() + "="  + "mul " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case DIV:
                ps.println(out.getName() + "="  + "sdiv " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case MOD:
                ps.println(out.getName() + "="  + "srem " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case AND_COND:
                ps.println(out.getName() + "="  + "and " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case OR_COND:
                ps.println(out.getName() + "="  + "or " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case XOR:
                ps.println(out.getName() + "="  + "xor " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case ASSIGN:
                ps.println(out.getName() + "=" + "add " + type + " " + var1.getName() + ", 0");
                break;
            case LT:
                ps.println(out.getName() + "=" + "icmp slt " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case LTE:
                ps.println(out.getName() + "=" + "icmp sle " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case GT:
                ps.println(out.getName() + "=" + "icmp sgt " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case GTE:
                ps.println(out.getName() + "=" + "icmp sge " + type + " " + var1.getName() + ", " + var2.getName());
                break;
            case EQ:
                ps.println(out.getName() + "=" + "icmp eq " + type + " " + var1.getName() + ", " + var2.getName());
                break;
        }
    }
}
