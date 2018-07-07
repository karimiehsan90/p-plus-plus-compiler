package code_generation;

public class LLVM_Type {
    public String name;
    public int size;
    public static final LLVM_Type i32 = new LLVM_Type("i32");
    public static final LLVM_Type i8 = new LLVM_Type("i8");
    public static final LLVM_Type i1 = new LLVM_Type("i1");
    public static final LLVM_Type i64 = new LLVM_Type("i64");
    public static final LLVM_Type floatType = new LLVM_Type("float");
    public LLVM_Type(String name) {
        this.name = name;
    }

    public LLVM_Type(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
