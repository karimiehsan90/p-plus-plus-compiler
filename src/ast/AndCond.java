package ast;

import code_generation.Opcode;
import parsers.Sym;

public class AndCond extends Terminal implements ConditionalOpr {
    public AndCond() {
        super(Sym.andLog,"and");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.AND_COND;
    }
}
