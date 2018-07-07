package code_generation;

public class Number extends LLVM_Var {
    public String value;


    public Number(String value) {
        super(null,null,true);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public String getName() {
        return value;
    }
}
