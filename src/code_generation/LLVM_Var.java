package code_generation;

public class LLVM_Var {
    public String name;
    public LLVM_Type type;
    public boolean isGlobal;

    public LLVM_Var(String name, LLVM_Type type, boolean isGlobal) {
        this.name = name;
        this.type = type;
        this.isGlobal = isGlobal;
    }

    public String getName() {
        if (isGlobal) {
            return "@" + name;
        }
        return "%" + name;
    }

    @Override
    public String toString() {
        return "LLVM_Var{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", isGlobal=" + isGlobal +
                '}';
    }
}
