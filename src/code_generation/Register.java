package code_generation;

public class Register extends LLVM_Var {
    private static int count = 0;

    public Register(LLVM_Type type) {
        super("r$" + (++count),type,false);
    }
    public static void reset(){
        count = 0;
    }
}
