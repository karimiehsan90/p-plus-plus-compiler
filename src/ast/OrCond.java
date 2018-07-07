package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class OrCond extends Terminal implements ConditionalOpr {
    public OrCond() {
        super(Sym.orLog,"or");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.OR_COND;
    }
}
