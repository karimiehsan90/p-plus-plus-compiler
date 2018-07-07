package ast;

import code_generation.Opcode;
import java_cup.runtime.Symbol;
import parsers.Sym;

public class OrArith extends Terminal implements ArithmaticOpr {
    public OrArith() {
        super(Sym.orArith,"|");
    }

    @Override
    public Opcode getOpcode() {
        return Opcode.OR_ARITH;
    }
}
